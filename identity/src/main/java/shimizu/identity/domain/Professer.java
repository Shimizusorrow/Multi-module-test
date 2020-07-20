package shimizu.identity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.identity.domain.base.Person;
import shimizu.identity.domain.object.StudentInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 测试一对多
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 9:50
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Professer extends Person {

    @ApiModelProperty("测试多对一")
    @ManyToOne
    private Teacher teacher;

    @ApiModelProperty("测试一对多")
    @JoinColumn(name = "stu_id")
    @OneToMany
    private List<StudentInfo> studentInfos;

}
