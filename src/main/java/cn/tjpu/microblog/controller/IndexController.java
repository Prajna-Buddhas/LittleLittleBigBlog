package cn.tjpu.microblog.controller;


import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    IndexService service;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/index")
    public List<Blog> getIndexRecommend() {


        return service.getIndexRecommend();
    }


}
