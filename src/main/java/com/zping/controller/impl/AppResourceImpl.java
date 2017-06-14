/**
 * 文 件 名:  AppResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/14 0014
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.controller.impl;

import com.zping.controller.AppResource;
import org.springframework.stereotype.Component;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/6/14 0014
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class AppResourceImpl implements AppResource
{
	@Override
	public String add () throws Exception
	{
		System.out.println (" method : add execute ... ");
		throw new Exception("dsfsdf");
		//return "hello zhouping";
	}
}
