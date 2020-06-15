package com.hqyj.SpringBootDemo.modules.account.service;


import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBootDemo.modules.account.entity.User;
import com.hqyj.SpringBootDemo.modules.common.vo.Result;
import com.hqyj.SpringBootDemo.modules.common.vo.SearchVo;

public interface UserService {

	Result<User> login(User user);
	
	//查名字接口
    User getUserByUserName(String userName);
    //增加数据接口
    Result<User> insertUser(User user);
    //删除数据接口
    Result<Object> deleteUser(int userId);
    //修改数据接口
    Result<User> updateUser(User user);
    
	PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
	//查ID接口
	User getUserByUserId(int userId);
    
}
