package com.baselogic.javaee6.service;

import com.baselogic.javaee6.dao.UserDao;
import com.baselogic.javaee6.domain.Customer;

/**
 * [Class_Name]
 *
 * @author Mick Knutson
 *         <a href="http://www.baselogic.com>Blog</a>< /br>
 *         <a href="http://linkedin.com/in/mickknutson>LinkedIN</a>< /br>
 *         <a href="http://twitter.com/mickknutson>Twitter</a>< /br>
 *         <a href="http://www.mickknutson.com>Personal</a>< /br>
 * @since 2011
 *        <i>To change this template use File | Settings | File Templates.</i>
 */
public class UserService{

    public UserDao userDao;

    public Customer findCustomer(String username) {
        return userDao.findCustomer(username);
    }
}