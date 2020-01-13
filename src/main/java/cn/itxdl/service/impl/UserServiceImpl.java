package cn.itxdl.service.impl;

import cn.itxdl.bean.Role;
import cn.itxdl.bean.User;
import cn.itxdl.bean.UserRoleMessage;
import cn.itxdl.mapper.RoleMapper;
import cn.itxdl.mapper.UserMapper;
import cn.itxdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(int id, String password) {
        return userMapper.findUser(id, password);
    }

    @Override
    public List<UserRoleMessage> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserRoleMessage selOne(int id) {
        return userMapper.selOne(id);
    }

    @Override
    @Transactional
    public int updateUser(int id, String username, String password, String sex, String phone, String email,String[] roles) {
        int flag = 0;
        int i1 = userMapper.updateUser(id, username, password, sex, phone, email);
        int i2 = userMapper.deleteUserRoleMapping(id);
        for(String rolename:roles){
            if(rolename.equals("1") || rolename.equals("2")){
                return i1;
            }
            int roleId = userMapper.findRoleId(rolename);
            flag = userMapper.addUserRoleMapping(id,roleId);
        }
        return flag;
    }

    @Override
    @Transactional
    public int addUser(int id, String username, String password, String sex, String phone, String email, String[] roles) {
        int i = userMapper.addUser(username, password, sex, phone, email);
        int flag = 0;
        if(i>0){
            for(String rolename:roles){
                int roleId = userMapper.findRoleId(rolename);
                flag = userMapper.addUserRoleMapping(id, roleId);
            }
        }
        return flag;
    }

    @Override
    public List<Role> insertPageRoles() {
        return roleMapper.findRoles();
    }

    @Override
    public int insertPageUserId() {
        return userMapper.findNextUserId();
    }

    @Override
    @Transactional
    public int deleteUser(int userid) {
        int i = userMapper.deleteUserRoleMapping(userid);
        int a =  userMapper.deleteUser(userid);
        return a;
    }

    @Override
    public int selUserNumber() {
        return userMapper.selCountUser();
    }
}
