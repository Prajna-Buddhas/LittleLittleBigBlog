package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.service.PublishBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @PostMapping("/publish")
    public String PublishBlog(Blog blog , HttpSession session) {
        publishBlogService.PublishBlog(blog,session);
        return "redirect:/index.html";
    }

    @ResponseBody
    @PostMapping("/photo")
    public String uploadPhoto(@RequestParam("uploadBlogImg")MultipartFile file) throws IOException {
        return publishBlogService.saveBlogImg(file);
    }
}
