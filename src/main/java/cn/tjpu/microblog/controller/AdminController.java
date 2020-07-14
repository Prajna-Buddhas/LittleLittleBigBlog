package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.dao.ViewBlogMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {


    @Resource
    AdminService service;
    @Resource
    PersonalDataMapper personalDataMapper;
    @Resource
    ViewBlogMapper viewBlogMapper;

    @PostMapping("/AdminLogin")
    public ModelAndView AdminLoginMapping(User user, HttpServletRequest request, ModelAndView modelAndView) {
        String status = service.adminLogin(user, request);
        if (!"success".equals(status)) {
            modelAndView.addObject("status", status);
            modelAndView.setViewName("AdminLogin");
        } else {
           AdminControl(modelAndView);
        }
        return modelAndView;
    }


    @RequestMapping("/AdminControl")
    public ModelAndView AdminControl(ModelAndView modelAndView) {
        modelAndView.setViewName("AdminControl");
        List<User> users = service.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping("/AdminBlog")
    public ModelAndView AdminBlog(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("AdminBlog");
        List<Blog> blogs = service.getAllBlogs();
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }


    @PostMapping("/deleteuser")
    public String deleteUser(Integer userId) {
        User user = new User();
        user.setUserId(userId);
        service.deleteUser(user);
        return "redirect:/AdminControl";
    }

    @PostMapping("/deleteblog")
    public String deleteBlog(Integer blogId) {
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        service.deleteBlog(blog);
        return "redirect:/AdminBlog";
    }

    @GetMapping("/Modify1/{id}")
    public ModelAndView update1(@PathVariable("id") Integer userId, ModelAndView modelAndView) {
        User user = new User();
        modelAndView.setViewName("ModifyUser");
        user.setUserId(userId);
        List<User> users = personalDataMapper.getUser(user);
        modelAndView.addObject("userInfo1", users.get(0));
        return modelAndView;
    }

    @PostMapping("/ModifyUser")
    public String updateUser(User user) {
        service.updateUser(user);
        return "redirect:/AdminControl";
    }




    @GetMapping("/Modify2/{id}")
    public ModelAndView update2(@PathVariable("id") Integer blogId, ModelAndView modelAndView) {
        Blog blog = new Blog();
        modelAndView.setViewName("ModifyBlog");
        blog.setBlogId(blogId);
        List<Blog> blogs = viewBlogMapper.getBlog(blogId);
        modelAndView.addObject("userInfo2", blogs.get(0));
        return modelAndView;
    }

    @PostMapping("/ModifyBlog")
    public String updateBlog(Blog blog) {
        service.updateBlog(blog);
        return "redirect:/AdminBlog";
    }

}
