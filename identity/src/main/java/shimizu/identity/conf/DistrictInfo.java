package shimizu.identity.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

/**
 * 地区信息编码
 *
 * @author shimizu
 * @date 2020年10月10日13:24:25
 */
@Component
@ConfigurationProperties(prefix = "district")
@Getter
@Setter
public class DistrictInfo {
    /**
     * 地区名字
     */
    private String districtName;
    /**
     * 区域编码
     */
    private String districtNumber;
}
