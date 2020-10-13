package shimizu.identity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import shimizu.common.annotion.APIVersion;
import shimizu.common.config.MessageConfig;
import shimizu.common.exception.BusinessException;
import shimizu.common.exception.CustomerException;
import shimizu.identity.domain.Student;
import shimizu.identity.repository.StuRepository;
import shimizu.identity.service.query.StuQueryService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shimizu
 */
@Api(tags = "学生")
@RestController
@AllArgsConstructor
@RequestMapping("/stu")
public class StudentController {
    private final StuQueryService stuQueryService;
    private final StuRepository stuRepository;

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

    @ApiOperation("测试多条件查询")
    @GetMapping("/duotiaojian")
    public List<Student> findsss(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String gender) {
        return stuQueryService.findByNameOrGender(name, gender);
    }

    @ApiOperation("测试多条件查询2")
    @GetMapping("/duotiaojian 2")
    public List<Student> findsss2(@RequestParam(required = false) String stuNumber,
                                  @RequestParam(required = false) String shoNumber) {
        return stuQueryService.findBySchool(stuNumber, shoNumber);
    }

    @ApiOperation("测试多条件查询3")
    @GetMapping("/duotiaojian 3")
    public Page<Student> findByNameAndShoNumberAndGender(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) String number,
                                                         @RequestParam(required = false) String gender,
                                                         Pageable pageable) {
        return stuQueryService.findByNameAndShoNumberAndGender(name, number, gender, pageable);
    }

//    @ApiOperation("测试导出Yml数组数据")
//    @GetMapping("/ymls-tier")
//    public String testYmlsTier() {
//        Stream.of(MessageConfig.tier).collect(Collectors.toList());
//    }


    @ApiOperation("0.0")
    @GetMapping("/tests")
    List<Student> findTest() {
        return stuQueryService.findTest();
    }

    @GetMapping("/findById-test")
    @ApiOperation("测试findById  id is null")
    public Student findByIdTest() {
        return stuRepository.findById(null)
                .orElseThrow(() -> new RuntimeException("学生不存在"));
    }
}

