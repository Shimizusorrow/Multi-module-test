package shimizu.common.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import shimizu.common.annotion.BosType;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @description: 存放扫包结果集
 * @author: Shimizu
 * @date: 2020/4/24 8:31
 * @param:
 * @return:
 */
//@Component
public class BosResult {
    @Autowired
    private BosTypeManager bosTypeManager;
    /**
     * 储存扫到的包名
     */
    private HashSet basePackages = new HashSet();

    private Class<?> aClass;

    public int size() {
        return basePackages.size();
    }

    public BosResult(Class c) {
        this.aClass = c;
        initEnum();
        initBosType();
    }

    /**
     * @description: 初始化 basePackages 内容
     * @author: Shimizu
     * @date: 2020/4/24 8:44
     * @param: []
     * @return: void
     */
//    @PostConstruct
    public void initEnum() {
        SpringBootApplication annotation = aClass.getAnnotation(SpringBootApplication.class);
        basePackages.addAll(Arrays.asList(annotation.scanBasePackages()));
        basePackages.addAll(Arrays.stream(annotation.scanBasePackageClasses())
                .map(it -> it.getPackage().getName())
                .collect(Collectors.toList()));
        if (basePackages.isEmpty()) {
            basePackages.add(aClass.getPackage().getName());
        }
    }

    /**
     * @description: 初始化填充
     * @author: Shimizu
     * @date: 2020/4/26 8:19
     * @param: []
     * @return: void
     */
    public void initBosType(){
        for (Object s: basePackages) {
            ClassPathScanningCandidateComponentProvider CPSCCP = new ClassPathScanningCandidateComponentProvider(false);
            CPSCCP.addIncludeFilter(new AnnotationTypeFilter(BosType.class));

            CPSCCP.findCandidateComponents((String) s).stream().map(it-> {
                try {
                    return Class.forName(it.getBeanClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("初始化BosType错误");
                }
            }).forEach(it->bosTypeManager.put(it));
        }
    }

    public HashSet getSet() {
        return basePackages;
    }
}
