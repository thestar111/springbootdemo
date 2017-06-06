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

import com.alibaba.druid.pool.DruidDataSource;
import com.zping.core.exception.CustomException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class MybatisConfig
{
	/*实体类包路径*/
	private static final String MODEL_PACKAGE_PATH = "com.zping.domain";

	/*mybatis配置文件路径*/
	private static final String MYBATIS_PATH = "classpath:/mybatis-config.xml";

	/*mybatis映射文件路径*/
	private static final String MAPPER_PATH = "classpath:/mapper/*.xml";

	@Autowired
	private DruidDataSource dataSource;

	@Bean (name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory()
	{
		System.out.print ("before ... ");
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ();
		sqlSessionFactoryBean.setDataSource (dataSource);
		//扫描DOMAIN包，可以使用别名
		sqlSessionFactoryBean.setTypeAliasesPackage (MODEL_PACKAGE_PATH);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver ();

		try
		{
			/*扫描mybatis配置文件*/
			sqlSessionFactoryBean.setConfigLocation (resolver.getResource (MYBATIS_PATH));
			sqlSessionFactoryBean.setMapperLocations (resolver.getResources (MAPPER_PATH));
			return sqlSessionFactoryBean.getObject ();
		}
		catch (Exception e)
		{
			throw new CustomException ("999", "init database failed.");
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate (sqlSessionFactory);
	}
}
