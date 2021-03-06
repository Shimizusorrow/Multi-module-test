package shimizu.identity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.common.annotion.BosType;
import shimizu.identity.domain.base.Person;
import shimizu.identity.domain.base.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * @author Shimizu
 */
@Entity
@ApiModel("老师")
@NoArgsConstructor
@Getter
@Setter
@BosType("TEA")
public class Teacher extends Person {
    /**
     * 系别 TODO 暂且做成String 应该抽出做成 对象 然后有系编码
     */
    @ApiModelProperty("系别")
    private String department;

    @ApiModelProperty("老师编号")
    private String teaNumber;

    @ApiModelProperty("教师级别:一级，二级，特级")
    private String teaLevel;

    @ApiModelProperty("入职时间")
    private String hireDate;

    @ApiModelProperty("一个账号")
    @OneToOne
    private User user;

//    @OneToMany
//    private Set<Process> parent;
}
