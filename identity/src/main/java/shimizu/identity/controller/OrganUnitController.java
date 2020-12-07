package shimizu.identity.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.common.exception.BusinessException;
import shimizu.identity.domain.OrganUnit;
import shimizu.identity.repository.OrganUnitRepository;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-07 16:11
 */
@RestController
@RequestMapping("/organ-unit")
@AllArgsConstructor
public class OrganUnitController {
    private final OrganUnitRepository organUnitRepository;

    @GetMapping
    List<OrganUnit> findAll() {
        return organUnitRepository.findAll();
    }

    @GetMapping("/id")
    OrganUnit findById(@PathVariable String id) {
        return organUnitRepository.findById(id).orElseThrow(() -> new BusinessException("机构不存在!"));
    }
}
