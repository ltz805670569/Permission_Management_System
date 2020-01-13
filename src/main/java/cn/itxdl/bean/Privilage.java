package cn.itxdl.bean;

import java.io.Serializable;
import java.util.Objects;

public class Privilage implements Serializable {
    private static final long serialVersionUID = 6041308461850761855L;
    private int privilageid;
    private String name;
    private String privilage_info;

    public Privilage() {
    }

    public Privilage(int privilageid, String name, String privilage_info) {
        this.privilageid = privilageid;
        this.name = name;
        this.privilage_info = privilage_info;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPrivilageid() {
        return privilageid;
    }

    public void setPrivilageid(int privilageid) {
        this.privilageid = privilageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilage_info() {
        return privilage_info;
    }

    public void setPrivilage_info(String privilage_info) {
        this.privilage_info = privilage_info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilage privilage = (Privilage) o;
        return privilageid == privilage.privilageid &&
                Objects.equals(name, privilage.name) &&
                Objects.equals(privilage_info, privilage.privilage_info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilageid, name, privilage_info);
    }

    @Override
    public String toString() {
        return "Privilage{" +
                "privilageid=" + privilageid +
                ", name='" + name + '\'' +
                ", privilage_info='" + privilage_info + '\'' +
                '}';
    }


}
