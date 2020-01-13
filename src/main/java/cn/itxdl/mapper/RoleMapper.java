package cn.itxdl.mapper;

import cn.itxdl.bean.Role;
import cn.itxdl.bean.RolePrivilageMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> findRoles();
    RolePrivilageMessage selOne(@Param("roleid") int roleid);
    List<RolePrivilageMessage> findAll();
    int updateRole(@Param("roleid") int roleid,@Param("rolename") String rolename,@Param("roleinfo") String roleinfo);
    int findPrivilageId(@Param("name") String name);
    int addRolePrivilageMapping(@Param("role_id") int role_id,@Param("privilage_id") int privilage_id);
    int deleteRolePrivilageMapping(@Param("role_id") int role_id);
    int deleteUserRoleMapping(@Param("role_id") int role_id);
    int findNextRoleId();
    int deleteRole(@Param("roleid") int roleid);
    int addRole(@Param("rolename") String rolename,@Param("roleinfo") String roleinfo);
    List<Role> selRoleListByUserId(@Param("id") int id);
    int selCountRole();
}
