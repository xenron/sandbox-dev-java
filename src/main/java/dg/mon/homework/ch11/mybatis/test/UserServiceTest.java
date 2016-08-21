package dg.mon.homework.ch11.mybatis.test;

import dg.mon.homework.ch11.mybatis.domain.User;
import dg.mon.homework.ch11.mybatis.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends SpringTestCase	{
	@Autowired
	private UserService userService;
	Logger logger = Logger.getLogger(UserServiceTest.class);
	
	@Test
	public void selectUserByIdTest(){
		User user = userService.selectUserById(1);
        logger.debug("查找结果" + user);
	}

}
