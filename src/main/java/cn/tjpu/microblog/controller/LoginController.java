package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录controller
 *
 * @author Trey
 * @since 2020/7/10
 */

@Controller
public class LoginController {

    @Resource
    LoginService service;

    @PostMapping("/login")
    public ModelAndView loginMapping(User user, HttpServletRequest request,ModelAndView modelAndView) {
        String status = service.login(user, request);
        if (!"success".equals(status)){
            modelAndView.addObject("status", status);
            modelAndView.setViewName("login");
        }
        else {
            modelAndView.setViewName("PersonalData");
        }
        return modelAndView;
    }
}
