package org.ecommerce.service;

import java.util.List;

import javax.annotation.Resource;

import org.ecommerce.entity.User;
import org.ecommerce.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource
	private UserDao userDao;
	
	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}
	
	public Page<User> findUserByPage(Pageable pageable){
		return userDao.findAll(pageable);
	}

	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	public User findUserByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
}
