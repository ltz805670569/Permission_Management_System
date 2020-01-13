package cn.itxdl.service;

import cn.itxdl.bean.Role;
import cn.itxdl.bean.User;
import cn.itxdl.bean.UserRoleMessage;

import java.util.List;

public interface UserService {
     User login(int id,String password);
     List<UserRoleMessage> findAll();
     UserRoleMessage selOne(int id);
     int updateUser(int id,String username,String password,String sex,String phone,String email,String[] roles);
     int addUser(int id,String username,String password,String sex,String phone,String email,String[] roles);
     List<Role> insertPageRoles();
     int insertPageUserId();
     int deleteUser(int userid);
     int selUserNumber();
}
