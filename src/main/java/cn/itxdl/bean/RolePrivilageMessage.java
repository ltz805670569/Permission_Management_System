package cn.itxdl.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class RolePrivilageMessage implements Serializable {
    private static final long serialVersionUID = -8838871102990375461L;
    private int roleid;
    private String rolename;
    private String roleinfo;
    private List<Privilage> privilages;

    public RolePrivilageMessage() {
    }

    public RolePrivilageMessage(int roleid, String rolename, String roleinfo, List<Privilage> privilages) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roleinfo = roleinfo;
        this.privilages = privilages;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
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

    public List<Privilage> getPrivilages() {
        return privilages;
    }

    public void setPrivilages(List<Privilage> privilages) {
        this.privilages = privilages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePrivilageMessage that = (RolePrivilageMessage) o;
        return roleid == that.roleid &&
                Objects.equals(rolename, that.rolename) &&
                Objects.equals(roleinfo, that.roleinfo) &&
                Objects.equals(privilages, that.privilages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, rolename, roleinfo, privilages);
    }

    @Override
    public String toString() {
        return "RolePrivilageMessage{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roleinfo='" + roleinfo + '\'' +
                ", privilages=" + privilages +
                '}';
    }
}
