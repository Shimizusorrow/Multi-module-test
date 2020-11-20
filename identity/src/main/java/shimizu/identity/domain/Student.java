package shimizu.identity.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.common.annotion.BosType;
import shimizu.identity.domain.base.Person;

import javax.persistence.Entity;

/**
 * @author Shimizu
 */
@Entity
@ApiModel("学生")
@NoArgsConstructor
@Getter
@Setter
@BosType(value = "STU")
public class Student extends Person {
    /**
     * 学号
     */
    @ApiModelProperty("学号")
    private String stuNumber;

    /**
     * 学位号(学号最后两位 用于表明在班级中的 位序)
     */
    @ApiModelProperty("学号位")
    private int shoNumber;

    /**
     * 系别 TODO 暂且做成String 应该抽出做成 对象 然后有系编码
     */
    @ApiModelProperty("系别")
    private String department;

    /**
     * 院校 TODO 暂且做成String 应该抽出做成 对象 然后有院校编码和地理位置信息
     */
    @ApiModelProperty("院校")
    private String academy;

    /**
     * 学制 3/4
     */
    @ApiModelProperty("学制")
    private int educationalSystem;

    /**
     * 入学时间
     */
    @ApiModelProperty("入学时间")
    private String enrollment;

    public Student(String id, String stuNumber, int shoNumber, String department, String academy, int educationalSystem, String enrollment) {
        this.setId(id);
        this.stuNumber = stuNumber;
        this.shoNumber = shoNumber;
        this.department = department;
        this.academy = academy;
        this.educationalSystem = educationalSystem;
        this.enrollment = enrollment;
    }
}
