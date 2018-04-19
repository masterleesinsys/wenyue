package com.wenyue.blog.home.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.wenyue.blog.home.entity.User;

@Repository
public class UserDao extends ABasicDao<User> {

	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(User.class);
	}
	
}