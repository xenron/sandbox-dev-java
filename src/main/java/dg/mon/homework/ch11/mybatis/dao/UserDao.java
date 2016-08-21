package dg.mon.homework.ch11.mybatis.dao;

import dg.mon.homework.ch11.mybatis.domain.User;

public interface UserDao {
	User selectUserById(Integer userId);

}
