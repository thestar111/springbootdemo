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
package com.zping.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.zping.core.exception.CustomException;
import com.zping.domain.User;

import java.io.IOException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JsonUtils
{
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper ();

	/**
	 * 对象JSON格式化
	 * @param o
	 * @return
	 */
	public static String toJson(Object o)
	{
		String result = "";
		try
		{
			result = OBJECT_MAPPER.writeValueAsString (o);
			return result;
		}
		catch (JsonProcessingException e)
		{
			throw new CustomException ("9999", "object to json error.");
		}
	}

	/**
	 * JSON格式转成对象
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz)
	{
		T result = null;
		try
		{
			result = OBJECT_MAPPER.readValue (json, clazz);
			return result;
		}
		catch (IOException e)
		{
			throw new CustomException ("9999", "json to object error.");
		}
	}

	/**
	 * JSON转换成Object
	 * 该方法支持集合泛型转换
	 * <code>例如构造List[String]类型：</code>
	 * <code>
	 *      TypeFactory.defaultInstance().constructCollectionLikeType(List.class, String.class);
	 * </code>
	 * @param json
	 * @param type
	 * @param <T>
	 * @return
	 */
	public static <T> T toObject(String json, JavaType type)
	{
		T result = null;

		try
		{
			result = OBJECT_MAPPER.readValue (json, type);
			return result;
		}
		catch (IOException e)
		{
			throw new CustomException ("9999", "json to object error.");
		}
	}
}
