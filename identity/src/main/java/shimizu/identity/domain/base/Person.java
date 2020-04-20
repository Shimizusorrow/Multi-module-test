package shimizu.identity.domain.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends SimpleEntity {

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private int age;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 出生地
     */
    private String birthplace;
}
