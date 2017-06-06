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
package com.zping.auth.filter;

import com.zping.utils.JsonUtils;
import com.zping.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OnlineAccess extends AccessControlFilter
{
	/**
	 * 权限拦截器，是否允许访问，通过返回true，否则false
	 * @param servletRequest
	 * @param servletResponse
	 * @param mappedValue 就是[urls]配置中拦截器参数部分
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean isAccessAllowed (ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue)
			throws Exception
	{
		/*Subject currentUser = SecurityUtils.getSubject ();
		if(currentUser.isAuthenticated ())
		{
			System.out.println ("user is authed.");
			return true;
		}*/
		return false;
	}

	/**
	 * 当访问拒绝时，上面那个方式返回false时，执行该方法
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied (ServletRequest servletRequest, ServletResponse servletResponse) throws Exception
	{
		System.out.println ("online denied access ... ");
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		response.setCharacterEncoding ("UTF-8");
		response.setContentType ("application/json; charset=UTF-8");
		PrintWriter print = response.getWriter ();
		Result<String> result = new Result<> ();
		result.setResultCode ("9998");
		result.setResultMsg ("user not login, not access.");
		print.write (JsonUtils.toJson (result));

		return false;
	}
}
