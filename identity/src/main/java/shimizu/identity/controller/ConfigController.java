package shimizu.identity.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.identity.conf.StaticConf;

@RestController
@RequestMapping("/config")
@AllArgsConstructor
public class ConfigController {

    @GetMapping("/test-static-conf")
    @ApiOperation("/测试静态@ConfigurationProperties注解")
    public void testStaticConf(){
        System.out.println(StaticConf.getName());
    }
}
