package shimizu.identity.controller.query;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.common.annotion.APIVersion;
import shimizu.identity.domain.Student;
import shimizu.identity.service.query.StuQueryService;

import java.util.List;

/**
 * @author Shimizu
 */
@RestController
@AllArgsConstructor
@RequestMapping("/stu")
public class StuQueryController {

    @Autowired
    private StuQueryService stuQueryService;


    @GetMapping("/{id}")
    @ApiOperation("通过id查找学生")
    @APIVersion
    public Student findById(@PathVariable String id){
        return stuQueryService.findById(id);
    }

    @GetMapping
    @ApiOperation("查找所有学生")
    @APIVersion
    public List<Student>findAll(){
        return stuQueryService.findAll();
    }
}
