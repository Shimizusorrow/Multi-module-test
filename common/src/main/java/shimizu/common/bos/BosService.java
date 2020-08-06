package shimizu.common.bos;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shimizu.common.basedomain.User;
import shimizu.common.exception.BusinessException;

import javax.persistence.EntityManager;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Filter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BosService<T> {
    private final EntityManager entityManager;
    private final BosTypeManager bosTypeManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Environment environment;

    public T find(String id) {
        return (T) entityManager.find(bosTypeManager.getClass(id), id);
    }

    @Modifying
    public void clearInformation(List<String> filter) {
        //从yml配置中拿配置的数据库名字
        String schema = getSchema();
        final String GET_TABLE_NAME = String.format("select TABLE_NAME from information_schema.`TABLES` where TABLE_SCHEMA = '%s'", schema);
        final String TRUNCATE_TABLE = "truncate ";
        List<String> tableNames = (List<String>) entityManager.createNativeQuery(GET_TABLE_NAME).getResultStream().collect(Collectors.toList());

        if (filter != null) {
            tableNames = tableNames.stream()
                    .filter(it -> !filter.contains(it)).collect(Collectors.toList());
        }

        tableNames = tableNames.stream()
                .map(it -> TRUNCATE_TABLE + it)
                .collect(Collectors.toList());
        /**
         * 删除外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        /**
         * 清除内容
         */
        tableNames.forEach(it -> entityManager.createNativeQuery(it).executeUpdate());
        /**
         * 启动外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();

        logger.info(String.format("输出当前执行的数量为%d", tableNames.size()));
    }

    /**
     * 获取数据库的名字
     *
     * @return
     */
    public String getSchema() {
        String url = environment.getProperty("spring.datasource.url");
        final String REGX = "[a-zA-Z0-9_]+\\?";
        Matcher matcher = Pattern.compile(REGX).matcher(url);
        if (matcher.find()) {
            return matcher.group().substring(0, matcher.group().length() - 1);
        } else {
            throw new BusinessException("数据库不存在 请检查配置文件");
        }
    }

    public void doSomething() {
        logger.info("do something" + Calendar.getInstance().getTime());
        Runtime runtime = Runtime.getRuntime();
        Process p = null;
        FileWriter fw = null;
        File file = new File(System.getProperty("user.dir") + "/sql");
        if (!file.exists()) {
            file.mkdir();
        }
        String schema = getSchema();
        String location = System.getProperty("user.dir") + "/sql/" + LocalDate.now().toString() + "_" + schema + ".sql";
        location = location.replaceAll("\\\\", "/");

        final String COMMAND_SAVE_SQL = String.format("cmd /c mysqldump -u root -proot %s > %s", schema, location);
        try {
            //此处执行的是ipconfig命令，可以换成任何cmd 里的命令。
            p = runtime.exec(COMMAND_SAVE_SQL);
            //获得执行的结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            // 将命令执行结果保存到文件中
            fw = new FileWriter(new File(System.getProperty("user.dir") + "/common/src/main/resources/text.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                fw.write(line + "\n");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.destroy();
            }
            try {
                if (fw != null)
                    fw.close();
                if (p != null)
                    p.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("do soming" + Calendar.getInstance().getTime());
    }

}
