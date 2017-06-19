/**
 * 文 件 名:  LogFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.controller.mapper;

import com.zping.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * <日志记录请求过滤器：支持名称绑定>
 *
 * @author zping
 * @version 2017/6/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Log
@Provider
@Priority (Priorities.USER)
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter
{

	private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void filter (ContainerRequestContext containerRequestContext) throws IOException
	{
		logger.info ("request log ... ");
	}

	@Override
	public void filter (ContainerRequestContext containerRequestContext,
			ContainerResponseContext containerResponseContext) throws IOException
	{
		logger.info ("response log ... ");
	}
}
