package shimizu.common.exception;

import lombok.Data;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/16 11:39
 */
@Data
public class CustomerException extends RuntimeException {
    /**
     * 返回标示码
     */
    private String code;

    /**
     * 返回详细信息
     */
    private String msg;

    public CustomerException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
