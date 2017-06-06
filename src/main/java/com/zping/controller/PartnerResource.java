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
package com.zping.controller;

import com.google.common.collect.Maps;
import com.zping.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/")
public class PartnerResource
{

	@POST
	@Path ("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> test()
	{
		Map<String, Object> maps = Maps.newHashMap ();
		maps.put ("resultCode", "0");
		return maps;
	}

	@POST
	@Path ("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Result<String> login()
	{
		System.out.println ("login ... ");
		Result<String> result = new Result<> ();

		Subject subject= SecurityUtils.getSubject();

		//先登出
		SecurityUtils.getSecurityManager ().logout (subject);

		if(!subject.isAuthenticated ())
		{
			UsernamePasswordToken token = new UsernamePasswordToken ("admin", "123456");
			subject.login (token);
			result.setResultCode ("0");
			result.setResultMsg ("login success.");
		}
		else
		{
			result.setResultCode ("0");
			result.setResultMsg ("user alerady login.");
		}
		return result;
	}
}
