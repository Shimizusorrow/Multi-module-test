package shimizu.common.bos;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shimizu.common.basedomain.User;
import shimizu.common.exception.BusinessException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
public class BosService<T> {
    private final EntityManager entityManager;
    private final BosTypeManager bosTypeManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Environment environment;

    public T find(String id) {
        return (T) entityManager.find(bosTypeManager.getClass(id), id);
    }

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public void clearInformation() {
        //从yml配置中拿配置的数据库名字
        String schema = getSchema(environment.getProperty("spring.datasource.url"));
        final String GET_TABLE_NAME = String.format("select TABLE_NAME from information_schema.`TABLES` where TABLE_SCHEMA = '%s'", schema);
        final String TRUNCATE_TABLE = "truncate ";
        List<String> tableNames = (List<String>) entityManager.createNativeQuery(GET_TABLE_NAME).getResultStream().collect(Collectors.toList());

        List<String> filter = Arrays.asList("user");

        List<String> rsTableNames = tableNames.stream()
                .filter(it -> !filter.contains(it))
                .map(it -> TRUNCATE_TABLE + it)
                .collect(Collectors.toList());

        /**
         * 删除外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        /**
         * 清除内容
         */
        rsTableNames.forEach(it -> entityManager.createNativeQuery(it).executeUpdate());
        /**
         * 启动外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();

        logger.info(String.format("输出当前执行的数量为%d", rsTableNames.size()));
    }

    /**
     * 提取String中 以?为结尾的 英文字符 + 数字 + _
     * @param url
     * @return
     */
    public String getSchema(String url) {
        final String REGX = "[a-zA-Z0-9_]+\\?";
        Matcher matcher = Pattern.compile(REGX).matcher(url);
        if (matcher.find()) {
            return matcher.group().substring(0, matcher.group().length() - 1);
        } else {
            throw new BusinessException("数据库不存在 请检查配置文件");
        }
    }

}
