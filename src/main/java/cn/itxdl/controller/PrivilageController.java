package cn.itxdl.controller;

import cn.itxdl.bean.PageMessage;
import cn.itxdl.bean.Privilage;
import cn.itxdl.service.PrivilageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrivilageController {
    private Privilage privilage;

    private PageMessage pageMessage = new PageMessage();

    @Autowired
    private PrivilageService privilageService;

    @RequestMapping(value = "/privilage",method = RequestMethod.GET)
    public String findAll(Model model){
        PageHelper.startPage(1,2);
        List<Privilage> privilages = privilageService.findAllPrivilages();
        PageInfo<Privilage> pageInfo = new PageInfo<>(privilages);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("privilages",privilages);
        return "privilage";
    }

    @RequestMapping(value = "/selPrivilagePage",method = RequestMethod.GET)
    @ResponseBody
    public List<Privilage> selPrivilagePage(@RequestParam("page") int page){
        PageHelper.startPage(page,2);
        List<Privilage> privilages = privilageService.findAllPrivilages();
        return privilages;
    }

    @RequestMapping(value = "/selOnePrivilage/{privilageid}",method = RequestMethod.GET)
    @ResponseBody
    public Privilage selOne(@PathVariable("privilageid") int privilageid){
        return privilageService.selOnePrivialge(privilageid);
    }

    @RequestMapping(value = "/toUpdatePrivilageTransfer",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toUpdatePrivilageTransfer(int privilageid, String name, String privilage_info){
        Map<String,String> map = new HashMap<>();
        Privilage privilage = new Privilage(privilageid,name,privilage_info);
        this.privilage = privilage;
        map.put("msg","success");
        return map;
    }

    @RequestMapping(value = "/toUpdatePrivilageFront",method = RequestMethod.POST)
    @ResponseBody
    public Privilage toUpdateFront(){
        return privilage;
    }

    @RequestMapping(value = "/updatePrivilage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updatePrivilage(int privilageid,String name,String privilage_info){
        Map<String,String> map = new HashMap<>();
        int i = privilageService.updatePrivilage(privilageid, name, privilage_info);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/insertPagePrivilageId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> insertPagePrivilageId(){
        Map<String,Integer> map = new HashMap<>();
        int nextPrivilageId = privilageService.selNextPrivilageId();
        map.put("nextPrivilageId",nextPrivilageId);
        return map;
    }

    @RequestMapping(value = "/addPrivilage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> toAddPrivilage(int privilageid,String name,String privilage_info){
        Map<String,String> map = new HashMap<>();
        int i = privilageService.insertPrivialge(name, privilage_info);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/deletePrivilage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deletePrivilage(int privilageid){
        Map<String,String> map = new HashMap<>();
        int i = privilageService.deletePrivialge(privilageid);
        if(i>0){
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/selPrivilagePageMessage",method = RequestMethod.GET)
    @ResponseBody
    public PageMessage selPrivialgePageMessage(){
        PageHelper.startPage(1,2);
        List<Privilage> privilages = privilageService.findAllPrivilages();
        PageInfo<Privilage> pageInfo = new PageInfo<>(privilages);
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
