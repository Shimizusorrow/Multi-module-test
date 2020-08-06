package shimizu.common.config;


import com.mysql.cj.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import javax.persistence.Tuple;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javax.swing.UIManager.get;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/18 9:23
 */
@Component
@Slf4j
public class InitDataApplicationContextInitializer implements ApplicationContextInitializer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SneakyThrows
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/common/src/main/resources/initData.yml"));
        FileInputStream inputStreams=new FileInputStream(new File(System.getProperty("user.dir") + "/common/src/main/resources/initData.yml"));;
        Map<String, Object> map2Object = yaml.load(inputStream);
        Map<String, Map<String,Object>> map2Map = yaml.load(inputStreams);

//        MessageConfig.TEST =  ((Map<String,Integer>)map2Object.get("spring")).get("url").toString();
        MessageConfig.TEST = map2Map.get("spring").get("url").toString();
        logger.info(String.format("一共导入了%s条 Yaml数据", map2Map.size()));

        logger.info("导入的数据是 : " + MessageConfig.TEST);


    }
}
