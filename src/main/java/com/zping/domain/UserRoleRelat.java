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
package com.zping.domain;

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
public class UserRoleRelat implements Serializable
{

	private static final long serialVersionUID = 4725004884032398431L;

	private Integer userId;

	private Integer roleId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("UserRoleRelat{");
		sb.append ("roleId=").append (roleId);
		sb.append (", userId=").append (userId);
		sb.append ('}');
		return sb.toString ();
	}
}
