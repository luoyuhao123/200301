package com.hqyj.SpringBootDemo.modules.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBootDemo.modules.account.entity.User;
import com.hqyj.SpringBootDemo.modules.account.service.UserService;
import com.hqyj.SpringBootDemo.modules.common.vo.Result;
import com.hqyj.SpringBootDemo.modules.common.vo.SearchVo;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/login",consumes = "application/json")
	public Result<User> login(@RequestBody User user){
		return userService.login(user);
	}
	
	/**
	 * 127.0.0.1/api/users ---- post
	 */
	@PostMapping(value = "/users", consumes = "application/json")
	public PageInfo<User> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
		return userService.getUsersBySearchVo(searchVo);
	}
	
	
	
	/**
	 * 查找控制器
	 * 127.0.0.1/api/user?userName=Tom&password=456 -----get
	 */
	@RequestMapping("/user")
	public User getUserByUserName(@RequestParam String userName ){
		return userService.getUserByUserName(userName);
	}
	/**
	 * 添加控制器
	 * 127.0.0.1/api/user -----post
	 */
	@PostMapping(value = "/user",consumes = "application/json")
	public Result<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	/**
	 * 删除控制器
	 * 127.0.0.1/api/users/  ------delete
	 */
	@DeleteMapping("/users/{userId}")
	public Result<Object> deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}
	/**
	 * 修改控制器
	 * 127.0.0.1/api/user ------put
	 */
	@PutMapping(value = "user",consumes = "application/x-www-form-urlencoded")
	public Result<User> updateUser(@ModelAttribute User user) {
		return userService.updateUser(user);
	}
	/**
	 * 127.0.0.1/api/user/3
	 */
	@RequestMapping("/user/{userId}")
	public User getUserByUserId(@PathVariable int userId) {
		return userService.getUserByUserId(userId);
	}
	
}
