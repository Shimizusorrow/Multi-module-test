package shimizu.common.bos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shimizu.common.annotion.APIVersion;

import java.util.List;

/**
 * @author Shimizu
 */
@Api("bos 相关查询")
@RequestMapping("/bos")
@RestController
@AllArgsConstructor
public class BosController<T> {
    private final BosService bosService;


    @GetMapping("/bos-entity/{id}")
    @APIVersion
    @ApiOperation("通过id查询实体信息")
    public T findEntity(@PathVariable String id) {
        return (T) bosService.find(id);
    }

    @GetMapping("/clear-information")
    @ApiOperation("清空数据 默认清除所有数据")
    public void clearInformation(@RequestParam(required = false) List<String> filter) {
        bosService.clearInformation(filter);
    }

}
