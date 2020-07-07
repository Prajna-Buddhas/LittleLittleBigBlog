package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.ViewBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ViewBlogController
 *
 * @author Trey
 * @since 2020/7/6
 */

@Controller
public class ViewBlogController {

    @Resource
    ViewBlogService service;

    @GetMapping("/blog/{id}")
    public ModelAndView ViewBlog(@PathVariable("id") Integer blogId, ModelAndView modelAndView) {
        modelAndView.setViewName("ViewBlog");
        Blog blog = service.getBlog(blogId);
        String author = service.getAuthorName(blogId);
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/blog/{id}/comments")
    public List<Map<String,Object>> getComments(@PathVariable("id") Integer blogId) {
        List<Map<String, Object>> maps = new ArrayList<>();
        List<Comment> comments = service.getComments(blogId);
        for (Comment comment : comments) {
            Map<String, Object> commentMap = service.commentConstructor(comment);
            maps.add(commentMap);
        }

        return maps;
    }

    @ResponseBody
    @RequestMapping("/blog/{id}/recommend")
    public List<Blog> getRecommend(@PathVariable("id") Integer blogId) {
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        return service.getRecommend(blog);
    }
}
