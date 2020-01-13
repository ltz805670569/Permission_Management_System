package cn.itxdl.service;

import cn.itxdl.bean.Privilage;
import cn.itxdl.bean.RolePrivilageMessage;

import java.util.List;

public interface RoleService {
    List<RolePrivilageMessage> findAll();
    RolePrivilageMessage selOne(int roleid);
    List<Privilage> insertPagePrivalages();
    int updateRole(int roleid,String rolename,String roleinfo,String[] privilages);
    int insertPagerRoleId();
    int addRole(int roleid, String rolename, String roleinfo, String[] privilages);
    int deleteRole(int roleid);
    int selRoleNumber();
}
