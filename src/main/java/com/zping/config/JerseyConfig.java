/*
 * 文 件 名:  JerseyConfig
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.config;

import com.zping.controller.impl.AppResourceImpl;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version TOP V100R001 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JerseyConfig extends ResourceConfig
{

    private static final String RESTFUL_BASE_PACKAGE = "com.zping.controller";

    public JerseyConfig()
    {
        System.out.println ("init resource ... ");
        register(RequestContextFilter.class);
        register (JacksonFeature.class);
        //register (AppResourceImpl.class);
        //启用扫描
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider (false);

        //扫描Path，provider
        scanner.addIncludeFilter (new AnnotationTypeFilter (Component.class));
        scanner.addIncludeFilter (new AnnotationTypeFilter (Provider.class));
        //将带有Path，Provider注解加入到资源中
        registerClasses (scanner.findCandidateComponents (RESTFUL_BASE_PACKAGE).stream ()
                .map (beanDefinition -> ClassUtils
                        .resolveClassName (beanDefinition.getBeanClassName (), this.getClassLoader ()))
                .collect(Collectors.toSet()));
        //package();  打成jar包后，会找不到注解的
        //packages ("");
    }
}
