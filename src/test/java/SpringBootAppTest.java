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

import com.zping.boot.SpringBootDemoApplication;
import com.zping.domain.User;
import com.zping.mapper.UserMapper;
import com.zping.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class SpringBootAppTest
{

	@Autowired
	private UserMapper userMapper;

	@Test
	public void addUser()
	{
		User user = new User ();
		user.setId (3);
		user.setPassword ("123456");
		user.setUsername ("zhouping");
		userMapper.addUser (user);
	}
}
