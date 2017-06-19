/**
 * 文 件 名:  AirDynamicLog
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.controller.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/6/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Provider
public class AirDynamicLog implements ContainerRequestFilter
{

	private static final Logger logger = LoggerFactory.getLogger(DynamicLog.class);

	@Override
	public void filter (ContainerRequestContext containerRequestContext) throws IOException
	{
		//logger.info (" dynamic bind log .... ");
	}
}
