package shimizu.identity.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shimizu.common.annotion.APIVersion;
import shimizu.common.exception.BusinessException;
import shimizu.common.exception.CustomerException;
import shimizu.identity.domain.Student;
import shimizu.identity.service.query.StuQueryService;

import java.util.List;

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
    public void testException(){
        throw new BusinessException("测试");
    }
}
