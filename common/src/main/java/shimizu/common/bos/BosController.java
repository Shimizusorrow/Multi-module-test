package shimizu.common.bos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.common.annotion.APIVersion;
import shimizu.common.annotion.BosType;

@Api("bos 相关查询")
@RequestMapping("/bos")
@RestController
//@AllArgsConstructor
public class BosController<T> {

    @Autowired
    private  BosTypeManager bosTypeManager;

    @GetMapping("/bos-entity/{id}")
    @APIVersion
    @ApiOperation("通过id查询实体信息")
    public Class<?> findEntity(@PathVariable String id){
        return bosTypeManager.getClass(id);
    }

}
