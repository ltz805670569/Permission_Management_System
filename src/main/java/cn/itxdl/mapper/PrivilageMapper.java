package cn.itxdl.mapper;

import cn.itxdl.bean.Privilage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilageMapper {
    int findPrivilageId(@Param("name") String name);
    List<Privilage> findPrivilages();
    List<Privilage> selPrivilagesByRoleId(@Param("roleid") int roleid);
    Privilage selOne(@Param("privilageid") int privilageid);
    int updatePrivilage(@Param("privilageid") int privilageid,@Param("name") String name,@Param("privilage_info") String privilage_info);
    int deletePrivilage(@Param("privilageid") int privilageid);
    int deleteRolePrivialgeMapping(@Param("privilage_id") int privilage_id);
    int insertPrivilage(@Param("name") String name,@Param("privilage_info") String privilage_info);
    int selNextPrivialgeid();
    int selCountPrivilage();
}
