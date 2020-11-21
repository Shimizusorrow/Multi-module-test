package shimizu.identity.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.identity.service.UserService;

import java.util.Properties;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/27 8:49
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public void TestEvent() {
        userService.testEventFail();
    }

    @GetMapping("/properties")
    public String testSystePro() {
        StringBuilder stringBuilder = new StringBuilder();
        System.getProperties().forEach((key, v) -> {
            stringBuilder.append(String.format("key:[%s] -> v:[%s]", key, v) + "\n");
        });
        return stringBuilder.toString();
    }

    @GetMapping("/env")
    public String testSystemEnv() {
        StringBuilder stringBuilder = new StringBuilder();
        System.getenv().forEach((k, v) -> {
            stringBuilder.append(String.format("k:[%s] -> v:[%s]", k, v) + "\n");
        });
        return stringBuilder.toString();
    }
}
