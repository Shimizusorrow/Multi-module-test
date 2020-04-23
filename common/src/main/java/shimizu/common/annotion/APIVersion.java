package shimizu.common.annotion;

import java.lang.annotation.*;
/**
 * @description: Swagger 版本号
 * @author: Shimizu
 * @date: 2020/4/23 13:50
 * @param:
 * @return:
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface APIVersion {
}
