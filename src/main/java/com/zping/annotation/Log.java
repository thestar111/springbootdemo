/**
 * 文 件 名:  Log
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/6/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.zping.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <添加扩展点，使用名称绑定>
 *
 * @author zping
 * @version 2017/6/16 0016
 * @see [自定义注解]
 * @since [产品/模块版本]
 */
@NameBinding
@Target ({ElementType.TYPE, ElementType.METHOD})
@Retention (RetentionPolicy.RUNTIME)
public @interface Log
{
}
