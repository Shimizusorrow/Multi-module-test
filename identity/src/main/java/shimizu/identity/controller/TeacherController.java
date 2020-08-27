package shimizu.identity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import shimizu.identity.domain.Teacher;
import shimizu.identity.repository.TeaRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/23 16:18
 */
@Api(tags = "老师")
@RestController
@RequestMapping("teacher")
@AllArgsConstructor
@ConditionalOnProperty(prefix = "tea",name = "enable",havingValue = "true")
public class TeacherController {
    private TeaRepository teaRepository;

    @ApiOperation("通过Id删除Teacher")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        teaRepository.deleteById(id);
    }

    @ApiOperation("查找所有的老师")
    @GetMapping
    public List<Teacher> findAll() {
        System.out.println(Arrays.asList("!!!!1","222222"));
        return teaRepository.findAll();
    }
}
