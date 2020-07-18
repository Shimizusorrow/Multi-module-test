package shimizu.identity.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shimizu.common.annotion.APIVersion;
import shimizu.common.config.MessageConfig;
import shimizu.common.exception.BusinessException;
import shimizu.common.exception.CustomerException;
import shimizu.identity.domain.Student;
import shimizu.identity.service.query.StuQueryService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shimizu
 */
@RestController
@AllArgsConstructor
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StuQueryService stuQueryService;


    @GetMapping("/{id}")
    @ApiOperation("通过id查找学生")
    @APIVersion
    public Student findById(@PathVariable String id) {
        return stuQueryService.findById(id);
    }

    @GetMapping
    @ApiOperation("查找所有学生")
    @APIVersion
    public List<Student> findAll() {
        return stuQueryService.findAll();
    }

    // 使用ModelMap也是一样效果 modelMap.get("author")
    @ApiOperation("测试抛出异常1")
    @GetMapping("/test/exception")
    public void test(@ModelAttribute("author") String author) {
        throw new CustomerException("500", "系统发生500异常, 编写异常罪魁祸首: " + author);
    }

    @ApiOperation("测试抛出异常2")
    @GetMapping("/test/exception2")
    public void testException() {
        throw new BusinessException("测试");
    }

    @ApiOperation("测试读取环境变量")
    @GetMapping("/getenv")
    public void gentenv() {
        System.getenv().forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    @ApiOperation("测试读取环境变量2")
    @GetMapping("/getProperty")
    public void getProperty() {
        System.getProperties().forEach((k, v) ->
                System.out.println(k + " : " + v));
    }

    @ApiOperation("测试修改环境变量")
    @GetMapping("/change-getenv")
    public void changeGentenv() {
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv.get("windir"));
        getenv.put("windir", "test1");
    }

    @ApiOperation("测试导出Yml数据")
    @GetMapping("/yml")
    public String testYml() {
        return MessageConfig.TEST;
    }

    @ApiOperation("测试导出Yml数组数据")
    @GetMapping("/ymls")
    public String testYmls() {
        return String.join(" ", MessageConfig.Messages);
    }
}
