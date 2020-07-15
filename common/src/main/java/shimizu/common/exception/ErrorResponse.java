package shimizu.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/15 9:08
 */
@Getter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    //错误码
    private String code;

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = "B" + code;
    }

    public ErrorResponse(String message, HttpStatus code) {
        this.message = message;
        this.code = "B" + code.value();
    }

}
