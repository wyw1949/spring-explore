package com.yoke;

import com.yoke.component.scan.config.FilterAnnotationConfig;
import com.yoke.component.scan.config.FilterAssignableConfig;
import com.yoke.component.scan.config.FilterScanConfig;
import com.yoke.component.scan.config.ResourcePatternConfig;
import com.yoke.component.scan.filter.annotation.*;
import com.yoke.component.scan.filter.assignable.AssignanleBeanOne;
import com.yoke.component.scan.filter.assignable.AssignanleBeanThree;
import com.yoke.component.scan.filter.assignable.AssignanleBeanTwo;
import com.yoke.component.scan.resource.pattern.ResourcePatternBean;
import com.yoke.component.scan.resource.pattern.ResourcePatternBeanPattern;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentScanTest {

    private void check(Class<?> configClass, List<Class<?>> wonderBeanClasses, List<Class<?>> notBeansClass, int beanCount){
        List<Object> beans = new ArrayList<>();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(configClass);
        for (Class c : wonderBeanClasses) {
            try{
                beans.add(ctx.getBean(c));
            }catch (Exception e){
                System.out.println("异常！" + e.getMessage());
            }
        }

        Assert.assertNotNull(beans);
        Assert.assertEquals(beans.size(), beanCount);

        List<Class<?>> beanClasses = beans.stream().map(Object::getClass).collect(Collectors.toList());
        List<Class<?>> excludes = wonderBeanClasses.stream().filter(o -> !beanClasses.contains(o)).collect(Collectors.toList());

        Assert.assertEquals(notBeansClass, excludes);

        System.out.println("清单:");
        System.out.println("\tclasses");
        wonderBeanClasses.forEach(o -> System.out.println("\t\t" + o.getName()));

        System.out.println("\tbeans");
        beanClasses.forEach(o -> System.out.println("\t\t" + o.getName()));

        System.out.println("\tnotBeans");
        notBeansClass.forEach(o -> System.out.println("\t\t" + o.getName()));
    }

    @Test
    public void resourcePattern(){
        List<Class<?>> wonderBeanClasses = new ArrayList<Class<?>>(){{
            add(ResourcePatternBean.class);
            add(ResourcePatternBeanPattern.class);
        }};
        List<Class<?>> notBeansClass = new ArrayList<Class<?>>(){{
            add(ResourcePatternBean.class);
        }};

        check(ResourcePatternConfig.class, wonderBeanClasses, notBeansClass, 1);
    }

    @Test
    public void includeAndExcludeFilter(){
        List<Class<?>> wonderBeanClasses = new ArrayList<Class<?>>(){{
            add(ExcludeFilterController.class);
            add(IncludeBeanComponent.class);
            add(IncludeBeanRepository.class);
            add(IncludeBeanService.class);
        }};
        List<Class<?>> notBeansClass = new ArrayList<Class<?>>(){{
            add(ExcludeFilterController.class);
        }};

        check(FilterScanConfig.class, wonderBeanClasses, notBeansClass, 3);
    }

    @Test
    public void includeAnnotationFilter(){
        List<Class<?>> wonderBeanClasses = new ArrayList<Class<?>>(){{
            add(ExcludeFilterController.class);
            add(IncludeBeanComponent.class);
            add(IncludeBeanRepository.class);
            add(IncludeBeanService.class);
            add(MybeanScanBean.class);
        }};
        List<Class<?>> notBeansClass = new ArrayList<Class<?>>(){{
            add(ExcludeFilterController.class);
            add(IncludeBeanComponent.class);
            add(IncludeBeanRepository.class);
            add(IncludeBeanService.class);
        }};

        check(FilterAnnotationConfig.class, wonderBeanClasses, notBeansClass, 1);
    }

    @Test
    public void includeAssignableFilter(){
        List<Class<?>> wonderBeanClasses = new ArrayList<Class<?>>(){{
            add(AssignanleBeanOne.class);
            add(AssignanleBeanThree.class);
            add(AssignanleBeanTwo.class);
        }};
        List<Class<?>> notBeansClass = new ArrayList<Class<?>>(){{
            add(AssignanleBeanThree.class);
        }};

        check(FilterAssignableConfig.class, wonderBeanClasses, notBeansClass, 2);
    }
}
