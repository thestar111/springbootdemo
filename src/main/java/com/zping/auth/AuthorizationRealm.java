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

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <权限验证Realm>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AuthorizationRealm extends AuthorizingRealm
{

	/**
	 * 权限验证
	 * 权限认证，为当前登录的Subject授予角色和权限
	 * @see 经测试：本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
	 * @see 经测试：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），超过这个时间间隔再刷新页面，该方法会被执行
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principalCollection)
	{
		SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo ();
		System.out.println ("auth user permsion ... ");
		return authenticationInfo;
	}

	/**
	 * 身份验证（是否登录系统）
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken authenticationToken)
			throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		System.out.println ("auth user token ... ");

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (token.getUsername (), token.getPassword (), this.getName ());
		return authenticationInfo;
	}
}
