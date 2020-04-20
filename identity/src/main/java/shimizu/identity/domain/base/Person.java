package shimizu.identity.domain.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import shimizu.common.basedomain.SimpleEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@ApiModel("基础信息")
public class Person extends SimpleEntity {

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String gender;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private int age;

    /**
     * 国籍
     */
    @ApiModelProperty("国籍")
    private String nationality;

    /**
     * 出生地
     */
    @ApiModelProperty("出生地")
    private String birthplace;

    /**
     * 出生年月
     */
    @ApiModelProperty("出生年月")
    private String birthDay;
}
