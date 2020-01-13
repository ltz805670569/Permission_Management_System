package cn.itxdl.mapper;

import cn.itxdl.bean.User;
import cn.itxdl.bean.UserRoleMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findUser(@Param("id") int id, @Param("password") String password);
    List<UserRoleMessage> findAll();
    UserRoleMessage selOne(@Param("id") int id);
    int updateUser(@Param("id") int id,@Param("username") String username,@Param("password") String password,@Param("sex") String sex,@Param("phone") String phone,@Param("email") String email);
    int findRoleId(@Param("rolename") String rolename);
    int addUser(@Param("username")String username,@Param("password") String password,@Param("sex") String sex,@Param("phone") String phone,@Param("email") String email);
    int addUserRoleMapping(@Param("user_id") int user_id,@Param("role_id") int role_id);
    int findNextUserId();
    int deleteUser(@Param("id") int id);
    int deleteUserRoleMapping(@Param("user_id") int user_id);
    int selCountUser();
}
