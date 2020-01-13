package cn.itxdl.test;

import cn.itxdl.bean.UserRoleMessage;
import cn.itxdl.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserMapper userMapper = app.getBean("userMapper", UserMapper.class);
        UserService userService = app.getBean("userService",UserService.class);
//        RoleService roleService = app.getBean("roleService", RoleService.class);
//        PageHelper.startPage(1,20);
//        List<RolePrivilageMessage> rolePrivilageMessages = roleService.findAll();
//        for(RolePrivilageMessage rolePrivilageMessage:rolePrivilageMessages){
//            System.out.println(rolePrivilageMessage);
//        }
        PageHelper.startPage(2, 5);
        List<UserRoleMessage> userRoleMessages = userService.findAll();
//        int size = userRoleMessages.size();
        PageInfo<UserRoleMessage> pageInfo = new PageInfo<>(userRoleMessages);
        int pages = pageInfo.getPages();
        int pageSize = pageInfo.getPageSize();
//        pageInfo.setTotal(size);
        long total = pageInfo.getTotal();
//        PageHelper.startPage(1, 6);
////        userRoleMessages = userService.findAll();
        System.out.println(pages+","+pageSize+","+total);

        for(UserRoleMessage userRoleMessage:userRoleMessages){
            System.out.println(userRoleMessage);
        }
//        User user = userMapper.findUser(1001, "123456");
//        System.out.println(user);
//        List<UserRoleMessage> userRoleMessageList = userMapper.findAll();
//        for(UserRoleMessage userRoleMessage:userRoleMessageList){
//            System.out.println(userRoleMessage);
//        }
//        UserRoleMessage userRoleMessage = userService.selOne(1001);
//        System.out.println(userRoleMessage);
//        RoleService roleService = app.getBean("roleService", RoleService.class);
//        List<RolePrivilageMessage> rolePrivilageMessages = roleService.findAll();
//        for(RolePrivilageMessage rolePrivilageMessage:rolePrivilageMessages){
//            System.out.println(rolePrivilageMessage);
//        }
//        RolePrivilageMessage rolePrivilageMessage = roleService.selOne(2);
//        System.out.println(rolePrivilageMessage);

//        char str = '?';
//        System.out.println( String.valueOf(str));
    }
}
