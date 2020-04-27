package shimizu.common.config;


import lombok.NoArgsConstructor;
import org.assertj.core.util.Streams;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import shimizu.common.annotion.BosType;
import shimizu.common.basedomain.SimpleEntity;
import shimizu.common.bos.BosResult;
import shimizu.common.bos.BosTypeManager;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
class ApplicationStartedTest {

    @Autowired
    BosTypeManager bosTypeManager;
    @Test
    public void t1() {
        Class<TestApplication> c =TestApplication.class;
        System.out.println("CanonicalName: "+c.getCanonicalName());
        System.out.println("Name: "+c.getName());
        System.out.println("SimpleName: "+c.getSimpleName());

        SpringBootApplication annotation = c.getAnnotation(SpringBootApplication.class);
        String[] strings = annotation.scanBasePackages();
        Class<?>[] classes = annotation.scanBasePackageClasses();
        List<String> collect = Arrays.stream(classes).map(it -> it.getPackage().getName()).collect(Collectors.toList());

        System.out.println(annotation.scanBasePackages()[0]);
        System.out.println(classes[0]);


//        Annotation annotation = c.getAnnotation(SpringBootApplication.class);
//        Class a=annotation.annotationType().getClass();

    }

//    @Test
//    public void t2(){
//        BosResult bosResult = new BosResult(TestApplication.class);
//        System.out.println(bosResult.size());
//        HashSet set = bosResult.getSet();
//        set.forEach(System.out::println);
//
//        System.out.println(bosTypeManager.size());
//
//        bosTypeManager.map().forEach((k,v)->{
//            System.out.println("key: "+ k+" value: "+v);
//        });
//
//    }
    @Test
    public void t3(){
        bosTypeManager.put(TestEntity.class);

        bosTypeManager.map().forEach((k,v)->{
            System.out.println("key: "+ k+" value: "+v);
        });
        TestEntity entity = new TestEntity();
        entity.setId("123456"+"S01");
        Class<?> aClass = bosTypeManager.getClass(entity.getId());

        System.out.println(aClass.getTypeName());

        Assert.assertEquals(TestEntity.class,aClass);
    }
}
@BosType("S01")
@Entity
@NoArgsConstructor
class TestEntity extends SimpleEntity {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TestEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@SpringBootApplication(scanBasePackages = {"shimizu.common"}, scanBasePackageClasses = TestApplication.class)
class TestApplication {
}