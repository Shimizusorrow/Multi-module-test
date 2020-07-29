package shimizu.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/29 9:03
 */
@Api(tags = "App")
@RestController
@RequestMapping("/app")
public class AppController {

    @ApiOperation("App开始")
    @GetMapping
    public String say(){
        return String.valueOf("Hello World!");
    }
}
