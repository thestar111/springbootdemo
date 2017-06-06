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
package com.zping.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Result<T> implements Serializable
{
	private static final long serialVersionUID = 7987051035259269069L;

	private String resultCode = "0";

	private String resultMsg = "success";

	private T result;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Result{");
		sb.append ("result=").append (result);
		sb.append (", resultCode='").append (resultCode).append ('\'');
		sb.append (", resultMsg='").append (resultMsg).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
