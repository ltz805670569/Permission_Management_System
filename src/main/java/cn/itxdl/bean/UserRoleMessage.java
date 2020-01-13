package cn.itxdl.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserRoleMessage implements Serializable {
    private static final long serialVersionUID = -7469473002142896496L;
    private int id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private int status;
    private List<Role> roles;

    public UserRoleMessage() {
    }

    public UserRoleMessage(int id, String username, String password, String sex, String phone, String email, int status, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleMessage that = (UserRoleMessage) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, sex, phone, email, status, roles);
    }

    @Override
    public String toString() {
        return "UserRoleMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}
