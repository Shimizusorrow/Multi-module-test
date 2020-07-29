package shimizu.identity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shimizu.identity.domain.Professor;
import shimizu.identity.repository.ProfessorRepository;
import shimizu.identity.service.ProfessorDomainService;

import java.util.List;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/20 11:58
 */

@Api(tags = "教授")
@AllArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorDomainService professorDomainService;
    private final ProfessorRepository professorRepository;

    @ApiOperation("新建 Professor")
    @PostMapping
    public Professor save(@RequestBody Professor professor) {
        return professorDomainService.save(professor);
    }

    @ApiOperation("查找所有的 Professor")
    @GetMapping("/findAll")
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
