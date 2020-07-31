package shimizu.common.bos;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 * @author Shimizu
 */
@Service
@AllArgsConstructor
public class BosService<T> {
    private final EntityManager entityManager;
    private final BosTypeManager bosTypeManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public T find(String id) {
        return (T) entityManager.find(bosTypeManager.getClass(id), id);
    }

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public void clearInformation() {
        StringBuilder stringBuilder = new StringBuilder("truncate professor;");
        //清除学生
        stringBuilder.append("truncate student;");
        //清除学生信息
        stringBuilder.append("truncate student_info;");
        //清除xxx
        stringBuilder.append("truncate vacate_apply_order;");

        String[] split = stringBuilder.toString().split(";");
        /**
         * 删除外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        /**
         * 清除内容
         */
        for (int i = 0; i < split.length ; i++) {
            entityManager.createNativeQuery(split[i]).executeUpdate();
        }
        /**
         * 启动外键约束
         */
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();

        logger.info(String.format("输出当前执行的数量为%d", 1));
    }

}
