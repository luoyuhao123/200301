package com.hqyj.SpringBootDemo.modules.account.service;


import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBootDemo.modules.account.entity.User;
import com.hqyj.SpringBootDemo.modules.common.vo.Result;
import com.hqyj.SpringBootDemo.modules.common.vo.SearchVo;

public interface UserService {

	Result<User> login(User user);
	
	//查名字接口
    User getUserByUserName(String userName);
    //删除数据接口
    Result<Object> deleteUser(int userId);
    
	PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
	//查ID接口
	User getUserByUserId(int userId);
    
	Result<User> editUser(User user);
	
	Result<String> uploadUserImage(MultipartFile userImage);

	Result<User> updateUserProfile(User user);
	
	void logout();
	
}
