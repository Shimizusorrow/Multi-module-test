package shimizu.common.bos;

import lombok.NoArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import shimizu.common.annotion.BosType;

import java.util.HashMap;


@Component
public class BosTypeManager {
    private static final int BOS_TYPE_SIZE = 3;

    private HashMap<String, Class<?>> bosTypeClassMap = new HashMap<>();

    /**
     * @description: 返回map长度
     * @author: Shimizu
     * @date: 2020/4/24 14:55
     * @param: []
     * @return: int
     */
    public int size() {
        return bosTypeClassMap.size();
    }

    /**
     * @description: 返回当前map
     * @author: Shimizu
     * @date: 2020/4/24 14:55
     * @param: []
     * @return: java.util.HashMap<java.lang.String, java.lang.Class < ?>>
     */
    public HashMap<String, Class<?>> map() {
        return this.bosTypeClassMap;
    }

    public void put(Class<?> aclass) {
        if (!aclass.isAnnotationPresent(BosType.class))
            throw new RuntimeException("class :" + aclass.getCanonicalName() + "所对应的BosType不存在");
        put(aclass.getDeclaredAnnotation(BosType.class).value(), aclass);
    }

    public void put(String bosyType, Class<?> aclass) {
        if (bosyType.length() != BOS_TYPE_SIZE) {
            throw new RuntimeException("bostype 的指定长度 : " + BOS_TYPE_SIZE + ", 当前值: " + bosyType.length());
        }
        if (bosTypeClassMap.containsKey(bosyType)) {
            Class<?> existClass = bosTypeClassMap.get(bosyType);
            if (existClass == aclass)
                throw new RuntimeException("bostype :" + bosyType + " 对应两个class"
                        + "已存在 class: " + existClass.getCanonicalName() + ",传入的class : " + aclass.getCanonicalName());
        }
        bosTypeClassMap.put(bosyType, aclass);
    }

    /**
     * @description: 获得对应的class对象
     * @author: Shimizu
     * @date: 2020/4/26 8:35
     * @param: [bosId]
     * @return: java.lang.Class<?>
     */
    public Class<?> getClass(String bosId) {
        String bosyType = bosId.substring(bosId.length() - BOS_TYPE_SIZE, bosId.length());
        Class<?> resultClass = bosTypeClassMap.get(bosyType);
        if (resultClass != null)
            return resultClass;
        else
            throw new RuntimeException("id " + bosId + "所对应的的 Class 不存在");
    }


}
