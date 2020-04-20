package shimizu.identity.domain;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.identity.domain.base.Person;

import javax.persistence.Entity;

@Entity
@ApiModel("学生")
@NoArgsConstructor
@Getter
@Setter
public class Student extends Person {
    /**
     * 学号
     */
    private int stuNumber;

    /**
     * 学位号(学号最后两位 用于表明在班级中的 位序)
     */
    private int shoNumber;

    /**
     *  系别 TODO 暂且做成String 应该抽出做成 对象 然后有系编码
     */
    private String department;

    /**
     *  院校 TODO 暂且做成String 应该抽出做成 对象 然后有院校编码和地理位置信息
     */
    private String academy;

    /**
     *  学制 3/4
     */
    private int eductionalSystem;
}
