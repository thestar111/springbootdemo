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
package com.zping.annotation;

import java.lang.annotation.*;

/**
 * <动态日志自定义注解>
 *
 * @author zping
 * @version 2017/6/19 0019
 * @see [自定义注解]
 * @since [产品/模块版本]
 */
@Documented
@Retention (RetentionPolicy.RUNTIME)
@Target ({ ElementType.METHOD,ElementType.TYPE})
public @interface DynaLog
{
}
