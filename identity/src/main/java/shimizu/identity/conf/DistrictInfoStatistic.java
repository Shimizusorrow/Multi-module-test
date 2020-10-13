package shimizu.identity.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 地区信息编码
 *
 * @author shimizu
 * @date 2020年10月10日13:24:25
 */
//@Component
//@ConfigurationProperties(prefix = "district-info-statistic")
@Getter
@Configuration
public class DistrictInfoStatistic {
    /**
     * 地区名字
     */
    public static String districtName;

    /**
     * 区域编码
     */
    public static String districtNumber;

    @Value("${districts.districtName}")
    public void setDistrictName(String districtName) {
        DistrictInfoStatistic.districtName = districtName;
    }

    @Value("${districts.districtNumber}")
    public void setDistrictNumber(String districtNumber) {
        DistrictInfoStatistic.districtNumber = districtNumber;
    }


}
