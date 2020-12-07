package shimizu.identity.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "static-conf")
public class StaticConf {
    private static boolean flag;
    private static String name;

    public void setFlag(boolean flag) {
        StaticConf.flag = flag;
    }

    public void setName(String name) {
        StaticConf.name = name;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static String getName() {
        return name;
    }
}
