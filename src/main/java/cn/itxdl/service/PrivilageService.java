package cn.itxdl.service;

import cn.itxdl.bean.Privilage;

import java.util.List;

public interface PrivilageService {
    List<Privilage> findAllPrivilages();
    Privilage selOnePrivialge(int privilageid);
    int updatePrivilage(int privialgeid,String name,String privilage_info);
    int deletePrivialge(int privilageid);
    int insertPrivialge(String name,String privilage_info);
    int selNextPrivilageId();
    int selPrivilageNumber();
}
