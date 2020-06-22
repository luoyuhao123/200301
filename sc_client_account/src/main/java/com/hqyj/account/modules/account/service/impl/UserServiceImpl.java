package com.hqyj.account.modules.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hqyj.account.modules.account.dao.UserDao;
import com.hqyj.account.modules.account.entity.City;
import com.hqyj.account.modules.account.entity.User;
import com.hqyj.account.modules.account.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User getUserByUserId(int userId) {
		User user = userDao.getUserByUserId(userId);
		List<City> cities =restTemplate.getForObject("http://CLIENT-SITE/api/cities/{countryId}", List.class,522);
		user.setCities(cities);
		return user;
	}

}
