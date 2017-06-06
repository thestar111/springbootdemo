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
package com.zping.auth;

import com.google.common.collect.Maps;
import com.zping.auth.filter.OnlineAccess;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class AuthorizationConfiguration
{

	/* Ehcache Xml */
	private static final String AUTH_EHCACHE_XML = "classpath:ehcache-shiro.xml";

	@Bean
	public EhCacheManager ehCacheManager()
	{
		EhCacheManager ehCacheManager = new EhCacheManager ();
		ehCacheManager.setCacheManagerConfigFile (AUTH_EHCACHE_XML);
		return ehCacheManager;
	}

	@Bean(name = "authorizationRealm")
	public AuthorizationRealm authorizationRealm(EhCacheManager ehCacheManager)
	{
		AuthorizationRealm authorizationRealm = new AuthorizationRealm ();
		authorizationRealm.setCacheManager (ehCacheManager);
		return authorizationRealm;
	}

	@Bean(name = "online")
	public OnlineAccess onlineAccess()
	{
		OnlineAccess online = new OnlineAccess ();
		return online;
	}

	/*@Bean
	public FilterRegistrationBean filterRegistrationBean()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean ();
		//生命周期由ServletContainer管理，false设置为Spring管理
		filterRegistrationBean.addInitParameter ("targetFilterLifecycle", "true");
		filterRegistrationBean.setEnabled (true);

		//设置拦截URL
		filterRegistrationBean.addUrlPatterns ("");

		return filterRegistrationBean;
	}*/

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor()
	{
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator()
	{
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator ();
		creator.setProxyTargetClass (true);
		return creator;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager defaultWebSecurityManager()
	{
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager ();
		EhCacheManager ehCacheManager = ehCacheManager ();
		securityManager.setRealm (authorizationRealm(ehCacheManager));
		/* 用户授权/认证信息Cache, 采用EhCache 缓存 */
		securityManager.setCacheManager (ehCacheManager);
		return securityManager;
	}

	/**
	 * 启用AOP注解
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager)
	{
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor ();
		authorizationAttributeSourceAdvisor.setSecurityManager (securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager, OnlineAccess online)
	{
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean ();
		shiroFilterFactoryBean.setSecurityManager (securityManager);
		shiroFilterFactoryBean.setLoginUrl ("/login.jsp");
		//shiroFilterFactoryBean.setSuccessUrl ("/rest/user");
		//shiroFilterFactoryBean.setUnauthorizedUrl ("");
		loadAuthChain(shiroFilterFactoryBean, online);
		return shiroFilterFactoryBean;
	}

	/**
	 * 权限配置
	 * @param shiroFilterFactoryBean
	 */
	private void loadAuthChain (ShiroFilterFactoryBean shiroFilterFactoryBean, OnlineAccess onlineAccess)
	{
		//自定义拦截器做权限验证
		Map<String, Filter> filters = Maps.newHashMap ();
		filters.put ("online", onlineAccess);
		shiroFilterFactoryBean.setFilters (filters);

		//拦截URL
		Map<String, String> filterChain = Maps.newLinkedHashMap ();
		filterChain.put ("/rest/test", "online");
		filterChain.put ("/rest/login", "anon");
		filterChain.put ("/**/access/test", "online");
		shiroFilterFactoryBean.setFilterChainDefinitionMap (filterChain);
	}
}
