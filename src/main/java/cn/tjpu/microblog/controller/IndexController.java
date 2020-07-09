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

    @ResponseBody
    @RequestMapping("/blog/{id}/recommend")
    public List<Blog> getIndexRecommend(@PathVariable("id") Integer blogId) {
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        return service.getIndexRecommend(blog);
    }


}
