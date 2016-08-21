package dg.mon.homework.ch11.mybatis.service;

import dg.mon.homework.ch11.mybatis.domain.User;

public interface UserService {
	User selectUserById(Integer userId);

}
