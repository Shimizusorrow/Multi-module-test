package shimizu.common.config;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/18 9:23
 */
@Component
@Slf4j
public class InitDataApplicationContextInitializer implements ApplicationContextInitializer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    private Environment environment;

    @SneakyThrows
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Yaml yaml = new Yaml();

        //            FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/common/src/main/resources/initData.yml"));
//            Map<String, Object> map = yaml.load(inputStream);

//            MessageConfig.TEST = (String) map.get("TEST");
//            MessageConfig.Messages = Stream.of(map.get("Messages")).collect(Collectors.toCollection(ArrayList::new));
//            MessageConfig.tier = (Object[][]) ((List) map.get("tier1")).toArray(new Object[0][0]);
//            Object config = map.get("InformationConfig");
//            InformationConfig.USER_ID=(String) config.getClass().getField("USER_ID").get(config);

//            logger.info(String.format("一共导入了%s条 Yaml数据", map.size()));
        FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/starter/src/main/resources/application-dev.yml"));
            Map<String, Object> map = yaml.load(inputStream);
            Object o = map.get("spring");
//            List<String>fd= (List<String>) o;
            logger.info(o.toString());
//            fd.forEach(it->logger.info(it));
//        for (String profile : environment.getDefaultProfiles()) {
//            logger.info(profile);
//        }


    }
}
