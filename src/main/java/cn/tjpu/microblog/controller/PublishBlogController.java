package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.service.PublishBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author 陈沿儒
 * @date 2020/7/8 - 10:05
 */

@Controller
public class PublishBlogController {

    @Resource

    PublishBlogService publishBlogService;

    @PostMapping("/publish/Blog")
    public String publishBlog(Blog blog , @RequestParam("uploadBlogImg")MultipartFile file, HttpServletRequest request) throws IOException {
        publishBlogService.publishBlog(blog,file,request.getSession());
        return "redirect:/index";
    }

    @GetMapping("/publish")
    public String publish() {
        return "/PublishBlog";
    }
}
