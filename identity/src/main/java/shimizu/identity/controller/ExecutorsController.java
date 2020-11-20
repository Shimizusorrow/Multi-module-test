package shimizu.identity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimizu.common.annotion.APIVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shimizu
 * @date 2020年11月7日13:26:59
 */
@Api(tags = "线程池测试")
@AllArgsConstructor
@RestController
@RequestMapping("/executors")
@APIVersion
public class ExecutorsController {
    /**
     * 静态线程池
     */
    private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

    @GetMapping("/1")
    @ApiOperation("测试使用静态线程池")
    public String testExecutorService() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int j = i;
            EXECUTOR_SERVICE.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(j);
                }
            });
        }
//        while (!EXECUTOR_SERVICE.isTerminated()) {
//            //pass
//        }
        return list.toString();
    }

    @GetMapping("/2")
    @ApiOperation("测试关闭静态线程池")
    public void testCloseExecutor() {
        // 平缓关闭
        EXECUTOR_SERVICE.shutdown();
    }

    @GetMapping("/3")
    @ApiOperation("测试使用局部变量线程池")
    public String testTempVariable() {
        List<Integer> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            final int j = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(j);
                }
            });
        }
        service.shutdown();
        while (!service.isTerminated()) {
            //pass
        }
        return list.toString();
    }
}
