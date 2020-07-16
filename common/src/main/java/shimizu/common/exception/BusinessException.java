package shimizu.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/16 11:30
 */
@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
