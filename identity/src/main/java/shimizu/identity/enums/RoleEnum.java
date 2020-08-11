package shimizu.identity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 身份信息
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/11 15:18
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {
    /**
     * 管理员 admin
     * 用户 user
     * 高级用户 senior_user
     */
    ADMIN("管理员"),
    SENIOR_USER("高级用户"),
    USER("用户");

    private String desc;
}
