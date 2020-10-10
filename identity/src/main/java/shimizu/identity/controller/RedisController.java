package shimizu.identity.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shimizu.identity.conf.DistrictInfo;
import shimizu.identity.service.RedisService;

/**
 * Test Redis
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/4 11:46
 */
@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisController {
    private final RedisService redisService;
    private final DistrictInfo districtInfo;

    @PostMapping("set-val")
    @ApiOperation("测试设置val")
    public boolean setVal(@RequestParam String key,
                          @RequestParam String val) {
        return redisService.setVal(key, val);
    }

    @PostMapping("get-val")
    @ApiOperation("测试拿取val")
    public String getVal(@RequestParam String key) {
        return redisService.getVal(key);
    }

    @GetMapping("connection")
    @ApiOperation("测试是否连接成功")
    public String connection() {
        redisService.connection();
        return "xxx";
    }

    @GetMapping("/area-test")
    @ApiModelProperty("测试地区编码")
    public String getArea() {
        return districtInfo.getDistrictName() + ": " + districtInfo.getDistrictNumber();
    }
}
