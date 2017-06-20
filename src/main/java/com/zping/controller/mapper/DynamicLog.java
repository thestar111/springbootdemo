/**
 * 文 件 名:  DynamicLog
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.controller.mapper;

import com.zping.annotation.DynaLog;
import com.zping.controller.impl.AccessResourceImpl;
import com.zping.filter.AirDynamicLogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

/**
 * <动态绑定：运行期间，匹配动态绑定扩展方法，切面provider就会被加载>
 *
 * @author zping
 * @version 2017/6/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Provider
public class DynamicLog implements DynamicFeature
{

	private static final Logger logger = LoggerFactory.getLogger (DynamicLog.class);

	@Override
	public void configure (ResourceInfo resourceInfo, FeatureContext context)
	{
		Method method = resourceInfo.getResourceMethod ();
		System.out.println (
				resourceInfo.getResourceClass () + " : " + resourceInfo.getResourceMethod () + " ---- " + resourceInfo
						.getResourceMethod ().getAnnotation (DynaLog.class));
		DynaLog dynaLog = resourceInfo.getResourceMethod ().getAnnotation (DynaLog.class);
		if (null != dynaLog)
		{
			//注入需要拦截的Filter
			context.register (AirDynamicLogFilter.class);
		}
	}
}
