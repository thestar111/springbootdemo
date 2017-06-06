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
package com.zping.core.exception;

import lombok.Getter;
import lombok.Setter;

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
public class CustomException extends RuntimeException
{
	private String resultCode;

	private String resultMessage;

	public CustomException ()
	{
	}

	/**
	 * @param cause
	 */
	public CustomException (Throwable cause)
	{
		super (cause);
	}

	/**
	 * @param resultMessage
	 */
	public CustomException (String resultMessage)
	{
		super();
		this.resultMessage = resultMessage;
	}

	/**
	 * @param resultCode
	 * @param resultMessage
	 */
	public CustomException (String resultCode, String resultMessage)
	{
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("CustomException{");
		sb.append ("resultCode='").append (resultCode).append ('\'');
		sb.append (", resultMessage='").append (resultMessage).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
