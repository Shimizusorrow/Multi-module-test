package shimizu.common.config;


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

import java.util.List;
import java.util.Map;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/18 9:23
 */
@Component
@Slf4j
public class InitDataApplicationContextInitializer implements ApplicationContextInitializer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Yaml yaml = new Yaml();

        try {
            FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/common/src/main/resources/initData.yml"));
            Map<String, Object> map = yaml.load(inputStream);

            MessageConfig.TEST = (String) map.get("TEST");
            MessageConfig.Messages = (String[]) ((List) map.get("Messages")).toArray(new java.lang.String[0]);

            logger.info(String.format("一共导入了%s条 Yaml数据", map.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
