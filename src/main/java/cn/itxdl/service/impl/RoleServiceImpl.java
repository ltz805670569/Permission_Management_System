package cn.itxdl.service.impl;

import cn.itxdl.bean.Privilage;
import cn.itxdl.bean.RolePrivilageMessage;
import cn.itxdl.mapper.PrivilageMapper;
import cn.itxdl.mapper.RoleMapper;
import cn.itxdl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PrivilageMapper privilageMapper;

    @Override
    public List<RolePrivilageMessage> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public RolePrivilageMessage selOne(int roleid) {
        return roleMapper.selOne(roleid);
    }

    @Override
    public List<Privilage> insertPagePrivalages() {
        return privilageMapper.findPrivilages();
    }

    @Override
    @Transactional
    public int updateRole(int roleid, String rolename, String roleinfo, String[] privilages) {
       int flag = 0;
       int i1 = roleMapper.updateRole(roleid, rolename, roleinfo);
       int i2 = roleMapper.deleteRolePrivilageMapping(roleid);
       for(String name:privilages){
           if(name.equals("1") || name.equals("2")){
               return i1;
           }
           int privilageId = roleMapper.findPrivilageId(name);
           flag = roleMapper.addRolePrivilageMapping(roleid,privilageId);
       }
       return flag;
    }

    @Override
    public int insertPagerRoleId() {
        return roleMapper.findNextRoleId();
    }

    @Override
    @Transactional
    public int addRole(int roleid, String rolename, String roleinfo, String[] privilages) {
        int flag = 0;
        int i1 = roleMapper.addRole(rolename, roleinfo);
        if(i1>0){
            for(String name:privilages){
                int privilageId = roleMapper.findPrivilageId(name);
                flag = roleMapper.addRolePrivilageMapping(roleid,privilageId);
            }
        }
        return flag;
    }

    @Override
    @Transactional
    public int deleteRole(int roleid) {
        int i = roleMapper.deleteRolePrivilageMapping(roleid);
        int j = roleMapper.deleteUserRoleMapping(roleid);
        int flag = roleMapper.deleteRole(roleid);
        return flag;
    }

    @Override
    public int selRoleNumber() {
        return roleMapper.selCountRole();
    }

}
