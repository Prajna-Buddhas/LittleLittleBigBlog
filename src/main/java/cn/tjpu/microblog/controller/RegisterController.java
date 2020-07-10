package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author 陈沿儒
 * @date 2020/7/8 - 15:40
 */

@Controller
public class RegisterController {
    @Resource
    RegisterService registerService;

    @PostMapping("/register")
    public String Register(User user) {
        registerService.register(user);
        return "redirect:/personalData";
    }
}
