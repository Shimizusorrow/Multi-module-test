package shimizu.common.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import shimizu.common.exception.ErrorResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常拦截
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/15 9:07
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    private ErrorResponse errorException(Exception e, HttpServletRequest request) {
        JSONObject jsonObject = JSONObject.parseObject(((HttpClientErrorException) e).getResponseBodyAsString());
        return new ErrorResponse((String) jsonObject.get("message"), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
