package cn.itxdl.bean;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
    private static final long serialVersionUID = -8227560261301802900L;
    private int roleid;
    private String rolename;
    private String roleinfo;

    public Role() {
    }

    public Role(int roleid, String rolename, String roleinfo) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roleinfo = roleinfo;
    }

    public int getId() {
        return roleid;
    }

    public void setId(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleinfo() {
        return roleinfo;
    }

    public void setRoleinfo(String roleinfo) {
        this.roleinfo = roleinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleid == role.roleid &&
                Objects.equals(rolename, role.rolename) &&
                Objects.equals(roleinfo, role.roleinfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, rolename, roleinfo);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roleinfo='" + roleinfo + '\'' +
                '}';
    }
}
