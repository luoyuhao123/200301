package com.hqyj.SpringBootDemo.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hqyj.SpringBootDemo.modules.account.entity.Role;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface RoleDao {

	//查找ID
	@Select("select * from role where roel_id = #{roleId}")
	List<Role> getRoleById(int roleId);
	
	//查找名字
	@Select("select * from role where role_name = #{roleName}")
	List<Role> getRoleByName(@Param("roleName") String roleName);
	
	//增添数据
	@Insert("insert into role (role_name) values(#{roleName})")
	@Options(useGeneratedKeys = true,keyColumn = "role_id",keyProperty = "role_id")
	void insertRole(Role role);
	
	//删除数据
	@Delete("delete from role where role_id = #{roleId}")
	void deleteRole (int roleId);
	
	//修改数据
	@Update("update roel set role_name=#{roleName} where role_id = #{roleId}")
	void updateRole(Role role);
	
	//查找role
	@Select("select * from role")
	List<Role> getRoles();
	
	@Select("select * from role role left join user_role userRole "
			+ "on role.role_id = userRole.role_id where userRole.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
	
}
