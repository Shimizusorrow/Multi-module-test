package shimizu.identity.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * 时间配置
 *
 * @author shimizu
 */
@Component
@ConfigurationProperties(prefix = "time-conf")
@Getter
@Setter
public class TimeConf {

//    @DurationUnit(ChronoUnit.SECONDS)
    private Duration duration;
}
