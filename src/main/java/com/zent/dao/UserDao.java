package com.zent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zent.entities.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
	
}
