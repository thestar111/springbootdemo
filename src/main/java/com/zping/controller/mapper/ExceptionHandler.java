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
package com.zping.controller.mapper;

import com.zping.core.exception.CustomException;
import com.zping.vo.Result;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * <自定义异常处理Handler>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>
{

	@Override
	public Response toResponse (Exception e)
	{
		Result<String> response = new Result<String> ();
		if(e instanceof CustomException)
		{
			response.setResultCode (((CustomException) e).getResultCode ());
			response.setResultMsg (((CustomException) e).getResultMessage ());
		}
		else
		{
			response.setResult ("9999");
			response.setResultMsg ("server error.");
		}
		return Response.ok ().status (505).entity (response).build ();
	}
}
