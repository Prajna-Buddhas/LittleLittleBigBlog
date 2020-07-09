package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.service.PublishBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 陈沿儒
 * @date 2020/7/8 - 10:05
 */

@Controller
public class PublishBlogController {

    @Resource
    PublishBlogService publishBlogService;

    @PostMapping("/publish")
    public String PublishBlog(Blog blog , HttpSession session) {
        publishBlogService.PublishBlog(blog,session);
        return "redirect:/index.html";
    }
}
