package com.yoke.config;

import com.yoke.component.scan.filter.assignable.AssignanleBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * ComponentScan常用功能详解
 * 1. 指定基础范围
 *      1).basePackages 以指定包的形式指定组件扫描器扫描的范围，指定的包及其子包
 *      2).basePackageClasses 以指定类的形式指定组件扫描器扫描范围的坐标，即指定类所在的包及其子包
 *    扫描规则默认是扫描范围内被标注了{@link @Component}(包含他的派生@Repository，@Service，@Controller，@Configuration等)的类
 *      由useDefaultFilters属性控制，若为true则启用默认扫描规则，false为关闭默认规则，此时要指定includeFilter属性来指定扫描规则
 * 2. 指定扫描规则
 *      1). resourcePattern
 *          指定从扫描结果中筛选资源的筛选规则，以ant风格的表达式。默认值为 {@link org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#DEFAULT_RESOURCE_PATTERN}
 *          指定的是ant风格相对路径，相对于basePackages
 *          useDefaultFilters为false时应额外指定includeFilters，否则会失效
 *          可以理解为：resourcePattern的规则是筛选规则，即从根据扫描规则扫描到的结果集中筛选除符合resourcePattern规则的子集。
 *          可以通过includeFilters和excludeFilters来实现resourcePattern的功能，并且比resourcePattern更灵活
 *      2). useDefaultFilters
 *          是否开启默认的扫描规则，true为开启  false为不开启
 *      3). includeFilters
 *          a.指定额外的扫描规则，即当useDefaultFilters=true时，扫描的结果集为includeFilters和默认规则的并集
 *              也就是说：当期望在指定包范围内只扫描@Controller标注的类时，如果useDefaultFilters=true，将达
 *              不到预期效果，必须将useDefaultFilters置为false
 *          b.多个includeFilters之间是或的关系
 *      4). excludeFilters
 *          a.指定从扫描结果中筛选资源的剔除规则，其意义类似于resourcePattern，只是这里是剔除规则
 *          b.多个excludeFilters之间是或的关系
 * 3.Filter的配置
 *      1).includeFilters或excludeFilters指定Filter,可指定多个Filter
 *      2).Filter配置项
 *          a. type
 *              aa. FilterType.ANNOTATION
 *                  指定注解类型，以指定的注解匹配，通过classes指定
 *              ab. FilterType.ASSIGNABLE_TYPE
 *                  指定类型，以指定的类型匹配，通过classes指定
 *              ac. FilterType.ASPECTJ
 *                  指定ASPECTJ表达式，以指定的切面表达式匹配，通过pattern指定
 *              ad. FilterType.REGEX
 *                  指定正则表达式，以指定的正则表达式匹配，通过pattern指定。匹配的是全限定类名
 *              ae. FilterType.CUSTOM
 *                  指定指定自定义的过滤器，以指定的自定义的过滤器匹配，通过classes指定，
 *                  要实现{@link org.springframework.core.type.filter.TypeFilter}
 *          b. classes
 *              当type=ANNOTATION/ASSIGNABLE_TYPE/CUSTOM时来指定类
 *          c. pattern
 *              当type=REGEX/ASPECTJ时来指定类
 */
@Configuration
@ComponentScan(
        basePackages = "com.yoke",
        useDefaultFilters = false,
        // 多个includeFilters是或的关系
        includeFilters = {
                // 该包下所有被@Component标记的类
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {Component.class}
                ),
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com\\.yoke\\.([a-z\\.A-Z])*\\.A([a-zA-Z])*Pattern"}
                ),
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {AssignanleBean.class}
                )
        }
)
public class SpringIocConfig {
}
