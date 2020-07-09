package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.service.PublishBlogService;
import cn.tjpu.microblog.service.ViewBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Trey
 * @since 2020/7/8
 */

@Controller
public class PublishBlogController {

    @Resource
    PublishBlogService service;

    @ResponseBody
    @PostMapping("/photo")
    public String uploadPhoto(@RequestParam("uploadBlogImg")MultipartFile file) throws IOException {
        return service.saveBlogImg(file);
    }
}
