package cn.itxdl.controller;

import cn.itxdl.service.PrivilageService;
import cn.itxdl.service.RoleService;
import cn.itxdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilageService privilageService;

    @RequestMapping(value = "/toHead",method = RequestMethod.GET)
    public String toHead(){
        return "head";
    }

    @RequestMapping(value = "/toMenu",method = RequestMethod.GET)
    public String toMenu(){
        return "menu";
    }

    @RequestMapping(value = "/toMain",method = RequestMethod.GET)
    public String toMain(){
        return "main";
    }

    @RequestMapping(value = "/toUser",method = RequestMethod.GET)
    public String toUser(){
        return "user";
    }

    @RequestMapping(value = "/toAddUser",method = RequestMethod.GET)
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping(value = "/toUpdateUser",method = RequestMethod.GET)
    public String toUpdateUser(){
        return "updateUser";
    }

    @RequestMapping(value = "/toGrantRole",method = RequestMethod.GET)
    public String toGrantRole(){
        return "grantRole";
    }

    @RequestMapping(value = "/toRole",method = RequestMethod.GET)
    public String toRole(){
        return "role";
    }

    @RequestMapping(value = "/toUpdateRole",method = RequestMethod.GET)
    public String toUpdatRole(){
        return "updateRole";
    }

    @RequestMapping(value = "/toAddRole",method = RequestMethod.GET)
    public String toAddRole(){
        return "addRole";
    }

    @RequestMapping(value = "/toGrantPermission",method = RequestMethod.GET)
    public String toGrantPermission(){
        return "grantPermission";
    }

    @RequestMapping(value = "/toPrivilage",method = RequestMethod.GET)
    public String toPermission(){
        return "privilage";
    }

    @RequestMapping(value = "/toAddPrivilage",method = RequestMethod.GET)
    public String toAddPrivilage(){
        return "addPrivilage";
    }

    @RequestMapping(value = "/toUpdatePrivilage",method = RequestMethod.GET)
    public String toUpdatePrivilage(){
        return "updatePrivilage";
    }

    @RequestMapping(value = "/toIntroduce",method = RequestMethod.GET)
    public String toIntroduce(){
        return "introduce";
    }

    @RequestMapping(value = "/toSelMainNumer",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> selMainNumber(){
        Map<String,Integer> map = new HashMap<>();
        int userNumber = userService.selUserNumber();
        int roleNumber = roleService.selRoleNumber();
        int privilageNumber = privilageService.selPrivilageNumber();
        map.put("userNumber",userNumber);
        map.put("roleNumber",roleNumber);
        map.put("privilageNumber",privilageNumber);
        return map;
    }
}
