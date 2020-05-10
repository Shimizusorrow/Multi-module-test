package shimizu.common.annotion;

import java.lang.annotation.*;
/**
 * @description 在类上标明注解 反射调用生成对象
 * @author Shimizu
 * @date 2020/4/23 13:28
 * @param
 * @return
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
public @interface BosType {
    String value();
}
