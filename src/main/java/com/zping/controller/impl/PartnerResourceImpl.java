/**
 * 文 件 名:  PartnerResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/14 0014
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.controller.impl;

import com.google.common.collect.Maps;
import com.zping.controller.PartnerResource;
import com.zping.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/6/14 0014
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class PartnerResourceImpl implements PartnerResource
{
	@Override
	public Map<String, Object> test ()
	{
		Map<String, Object> maps = Maps.newHashMap ();
		maps.put ("resultCode", "0");
		return maps;
	}

	@Override
	public Result<String> login ()
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
