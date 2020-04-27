package shimizu.common.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import shimizu.common.bos.BosResult;
import shimizu.common.bos.BosTypeManager;

/**
 * @description: Application启动后自动扫描
 * @author: Shimizu
 * @date: 2020/4/23 14:49
 * @param:
 * @return:
 */

//@Order(1)
//@Component

//@ComponentScan("shimizu.common")
//@Configuration

public class ApplicationStarted implements ApplicationListener<ApplicationStartedEvent> {

//    @Autowired
//    private  BosTypeManager bosTypeManager;


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Class<?> mainClass = event.getSpringApplication().getMainApplicationClass();
        //Autowired 拿不到bosTypeManager???
        BosTypeManager bosTypeManager=event.getApplicationContext().getBean(BosTypeManager.class);

//        BosResult result = new BosResult(mainClass,bosTypeManager);
        BosResult result = new BosResult(mainClass);

        result.initBosType(bosTypeManager);
//        result.initEnum();
//        result.initBosType();
//        System.out.println("+++++"+mainClass.getSimpleName());
//        result.initBosType();
//        result.initEnum();

    }
}
