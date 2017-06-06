/*
 * 文 件 名:  JerseyConfig
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.core.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <功能详细描述>
 * AutoConfigureAfter : 必须加上，因为初始化MapperScanConfig类的时候，依赖SqlSessionFactory类
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScanConfig
{

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer()
	{
		System.out.print ("after ... ");
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer ();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage ("com.zping.mapper");
		return mapperScannerConfigurer;
	}
}
