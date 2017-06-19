/**
 * 文 件 名:  AccessResourceImpl
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
import com.zping.annotation.DynaLog;
import com.zping.controller.AccessResource;
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
@DynaLog
public class AccessResourceImpl implements AccessResource
{
	@Override
	public Map<String, Object> test () throws Exception
	{
		Map<String, Object> maps = Maps.newHashMap ();
		maps.put ("resultCode", "0");
		return maps;
	}

	@DynaLog
	@Override
	public Map<String, Object> sayHello () throws Exception
	{
		Map<String, Object> maps = Maps.newHashMap ();
		maps.put ("resultCode", "0");
		return maps;
	}
}
