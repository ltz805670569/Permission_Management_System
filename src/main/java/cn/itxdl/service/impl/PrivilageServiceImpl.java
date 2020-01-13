package cn.itxdl.service.impl;

import cn.itxdl.bean.Privilage;
import cn.itxdl.mapper.PrivilageMapper;
import cn.itxdl.service.PrivilageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("privilageService")
public class PrivilageServiceImpl implements PrivilageService {

    @Autowired
    private PrivilageMapper privilageMapper;

    @Override
    public List<Privilage> findAllPrivilages() {
        return privilageMapper.findPrivilages();
    }

    @Override
    public Privilage selOnePrivialge(int privilageid) {
        return privilageMapper.selOne(privilageid);
    }

    @Override
    @Transactional
    public int updatePrivilage(int privialgeid, String name, String privilage_info) {
        return privilageMapper.updatePrivilage(privialgeid,name,privilage_info);
    }

    @Override
    @Transactional
    public int deletePrivialge(int privilageid) {
        int i = privilageMapper.deleteRolePrivialgeMapping(privilageid);
        int flag = privilageMapper.deletePrivilage(privilageid);
        return flag;
    }

    @Override
    @Transactional
    public int insertPrivialge(String name, String privilage_info) {
        return privilageMapper.insertPrivilage(name, privilage_info);
    }

    @Override
    public int selNextPrivilageId() {
        return privilageMapper.selNextPrivialgeid();
    }

    @Override
    public int selPrivilageNumber() {
        return privilageMapper.selCountPrivilage();
    }
}
