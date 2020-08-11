package shimizu.identity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 10:00
 */
@AllArgsConstructor
@Getter
public enum StudentStateEnum {
    /**
     *  学生状态
     */
    NORMAL("正常"),
    ERROR("异常");
    private String desc;
}
