package dg.mon.homework.ch11.mybatis.service;

import dg.mon.homework.ch11.mybatis.dao.UserDao;
import dg.mon.homework.ch11.mybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public User selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}

}
