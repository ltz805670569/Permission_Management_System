package cn.itxdl.controller;

import cn.itxdl.bean.PageMessage;
import cn.itxdl.bean.Role;
import cn.itxdl.bean.User;
import cn.itxdl.bean.UserRoleMessage;
import cn.itxdl.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private PageMessage pageMessage = new PageMessage();

    private UserRoleMessage userRoleMessage;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(int username, String password, HttpServletRequest request){
        User user = userService.login(username, password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "redirect:toIndex";
        }else{
            request.setAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toMain(){
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String  findAll(Model model){
        PageHelper.startPage(1,2);
        List<UserRoleMessage> userRoleMessages = userService.findAll();
        PageInfo<UserRoleMessage> pageInfo = new PageInfo<>(userRoleMessages);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("userRoleMessages",userRoleMessages);
        return "user";
    }

    @RequestMapping(value="/selPage",method = RequestMethod.GET)
    @ResponseBody
    public List<UserRoleMessage> toSelPage(@RequestParam("page") Integer page){
        PageHelper.startPage(page, 2);
        List<UserRoleMessage> userRoleMessages = userService.findAll();
        return userRoleMessages;
    }

    @RequestMapping(value = "/selOne/{id}",method = RequestMethod.GET)
    @ResponseBody
    public UserRoleMessage selOne(@PathVariable("id") int id){
        return userService.selOne(id);
    }

    @RequestMapping(value = "/toUpdateTransfer",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toUpdateTransfer(int id,String username,String password,String sex,String phone,String email,int status,String roles){
        Map<String,String> map = new HashMap<>();
        List<Role> rolenames = new LinkedList<>();
//        System.out.println(roles);
        String[] split = roles.split(",");
//        for(String rolename:split){
//            System.out.println(rolename);
//        }
        for(int i=0;i<split.length;i++){
            Role role = new Role();
            role.setRolename(split[i]);
            rolenames.add(role);
        }
        UserRoleMessage userRoleMessage = new UserRoleMessage();
        userRoleMessage.setId(id);
        userRoleMessage.setUsername(username);
        userRoleMessage.setPassword(password);
        userRoleMessage.setSex(sex);
        userRoleMessage.setPhone(phone);
        userRoleMessage.setEmail(email);
        userRoleMessage.setStatus(status);
        userRoleMessage.setRoles(rolenames);
        this.userRoleMessage = userRoleMessage;
        map.put("msg","success");
        return map;
    }

    @RequestMapping(value = "/toUpdateFront",method = RequestMethod.POST)
    @ResponseBody
    public UserRoleMessage toUpdateFront(){
        return userRoleMessage;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateUser(int id,String username,String password,String sex,String phone,String email,@RequestParam(value = "roles[]") String[] roles){
        Map<String,String> map = new HashMap<>();
        int i = userService.updateUser(id, username, password, sex, phone, email, roles);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addUser(int id,String username,String password,String sex,String phone,String email,@RequestParam(value = "roles[]") String[] roles){
        Map<String,String> map = new HashMap<>();
        int i = userService.addUser(id, username, password, sex, phone, email, roles);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/insertPageRoles",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> insertPageRoles(){
        return userService.insertPageRoles();
    }

    @RequestMapping(value = "/insertPageUserId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> insertPageUserId(){
        Map<String,Integer> map = new HashMap<>();
        int nextUserId = userService.insertPageUserId();
        map.put("nextUserId",nextUserId);
        return map;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteUser(int userid){
        Map<String,String> map = new HashMap<>();
        int i = userService.deleteUser(userid);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/selUserPageMessage",method = RequestMethod.GET)
    @ResponseBody
    public PageMessage selUserPageMessage(){
        PageHelper.startPage(1,2);
        List<UserRoleMessage> userRoleMessages = userService.findAll();
        PageInfo<UserRoleMessage> pageInfo = new PageInfo<>(userRoleMessages);
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
