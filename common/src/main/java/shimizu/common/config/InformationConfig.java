package shimizu.common.config;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/18 15:40
 */
@Getter
@Setter
public class InformationConfig {

    public static String USER_ID;

    public static Integer AGE;

    public static List<String> QQ_NUMBER;
}
