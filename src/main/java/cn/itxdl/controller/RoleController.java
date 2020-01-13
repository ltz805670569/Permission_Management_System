package cn.itxdl.controller;

import cn.itxdl.bean.PageMessage;
import cn.itxdl.bean.Privilage;
import cn.itxdl.bean.RolePrivilageMessage;
import cn.itxdl.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    private PageMessage pageMessage = new PageMessage();

    private RolePrivilageMessage rolePrivilageMessage;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public String findAll(Model model){
        PageHelper.startPage(1,2);
        List<RolePrivilageMessage> rolePrivilageMessages = roleService.findAll();
        PageInfo<RolePrivilageMessage> pageInfo = new PageInfo<>(rolePrivilageMessages);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("rolePrivilageMessages",rolePrivilageMessages);

        return "role";
    }

    @RequestMapping(value = "/selRolePage",method = RequestMethod.GET)
    @ResponseBody
    public List<RolePrivilageMessage> selRolePage(@RequestParam("page") int page){
        PageHelper.startPage(page,2);
        List<RolePrivilageMessage> rolePrivilageMessages = roleService.findAll();
        return rolePrivilageMessages;
    }

    @RequestMapping(value = "/selOneRole/{roleid}",method = RequestMethod.GET)
    @ResponseBody
    public RolePrivilageMessage selOne(@PathVariable("roleid") int roleid){
        return roleService.selOne(roleid);
    }

    @RequestMapping(value = "/toUpdateRoleTransfer",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toUpdateRoleTransfer(int roleid, String rolename, String roleinfo, String privilages){
        Map<String,String> map = new HashMap<>();
        List<Privilage> names = new LinkedList<>();
        String[] split = privilages.split(",");
        for(int i=0;i<split.length;i++){
            Privilage privilage = new Privilage();
            privilage.setName(split[i]);
            names.add(privilage);
        }
        RolePrivilageMessage rolePrivilageMessage = new RolePrivilageMessage();
        rolePrivilageMessage.setRoleid(roleid);
        rolePrivilageMessage.setRolename(rolename);
        rolePrivilageMessage.setRoleinfo(roleinfo);
        rolePrivilageMessage.setPrivilages(names );
        this.rolePrivilageMessage = rolePrivilageMessage;
        map.put("msg","success");
        return map;
    }

    @RequestMapping(value = "/toUpdateRoleFront",method = RequestMethod.POST)
    @ResponseBody
    public RolePrivilageMessage toUpdateFront(){
        return rolePrivilageMessage;
    }

    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateRole(int roleid,String rolename,String roleinfo,@RequestParam(value = "privilages[]") String[] privilages){
        Map<String,String> map = new HashMap<>();
        int i = roleService.updateRole(roleid, rolename, roleinfo, privilages);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/insertPagePrivilages",method = RequestMethod.GET)
    @ResponseBody
    public List<Privilage> toInsertPagePrivilages(){
        return roleService.insertPagePrivalages();
    }

    @RequestMapping(value = "/insertPageRoleId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> insertPageRoleId(){
        Map<String,Integer> map = new HashMap<>();
        int nextRoleId = roleService.insertPagerRoleId();
        map.put("nextRoleId",nextRoleId);
        return map;
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toAddRole(int roleid,String rolename,String roleinfo, @RequestParam(value = "privilages[]") String[] privilages){
        Map<String,String> map = new HashMap<>();
        int i = roleService.addRole(roleid,rolename,roleinfo,privilages);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/deleteRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteRole(int roleid){
        Map<String,String> map = new HashMap<>();
        int i = roleService.deleteRole(roleid);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/selRolePageMessage",method = RequestMethod.GET)
    @ResponseBody
    public PageMessage selRolePageMessage(){
        PageHelper.startPage(1,2);
        List<RolePrivilageMessage> rolePrivilageMessages = roleService.findAll();
        PageInfo<RolePrivilageMessage> pageInfo = new PageInfo<>(rolePrivilageMessages);
        int pageSize = pageInfo.getPageSize();
        int pageNum = pageInfo.getPageNum();
        int pages = pageInfo.getPages();
        int pagePre = pageInfo.getPrePage();
        int pageNext = pageInfo.getNextPage();
        pageMessage.setPageSize(pageSize);
        pageMessage.setPageNum(pageNum);
        pageMessage.setPages(pages);
        pageMessage.setPagePre(pagePre);
        pageMessage.setPageNext(pageNext);
        return pageMessage;
    }

}
