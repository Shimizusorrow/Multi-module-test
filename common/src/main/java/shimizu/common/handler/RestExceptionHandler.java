package shimizu.common.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import shimizu.common.exception.BusinessException;
import shimizu.common.exception.CustomerException;
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
    /**
     * 打印日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 应用到所有@RequestMapping, 在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中, 使全局@RequestMapping可以获取该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "MaLongT");
    }

    /**
     * 统一 CustomerException 异常拦截
     *
     * @param e       异常
     * @param request 请求
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomerException.class)
    private ErrorResponse errorException(CustomerException e, HttpServletRequest request) {
        // false 表示异常信息不是系统类异常
        logThrowable(false, request, e);
        return new ErrorResponse(e.getMsg(), e.getCode());

    }

    /**
     * 统一 BusinessException 异常拦截
     *
     * @param e       异常
     * @param request 请求
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(BusinessException.class)
    private ErrorResponse errorException(BusinessException e, HttpServletRequest request) {
        // false 表示异常信息不是系统类异常
        logThrowable(false, request, e);
        return new ErrorResponse(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

    }


    private void logThrowable(boolean error, HttpServletRequest request, Throwable throwable) {
        if (error) {
            this.logger.error("[" + request.getMethod() + "] " + request.getRequestURI() + (StringUtils.isEmpty(request.getQueryString()) ? "" : "?" + request.getQueryString()) + " ", throwable);
        } else if (this.logger.isInfoEnabled()) {
            this.logger.info("[" + request.getMethod() + "] " + request.getRequestURI() + (StringUtils.isEmpty(request.getQueryString()) ? "" : "?" + request.getQueryString()));
        }
    }
}
