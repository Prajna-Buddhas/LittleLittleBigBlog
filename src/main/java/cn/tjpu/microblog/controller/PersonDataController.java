package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.PersonalDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 个人数据页面
 *
 * @author Trey
 * @since 2020/7/10
 */

@Controller
public class PersonDataController {

    @Resource
    PersonalDataMapper mapper;
    @Resource
    PersonalDataService personalDataService;

    @GetMapping("/personalData")
    public ModelAndView getPersonalData(ModelAndView modelAndView, HttpSession session) {
        User user = (User) session.getAttribute("userInfo");
        modelAndView.setViewName("PersonalData");
        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("nickname", user.getNickname());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("birthday", user.getBirthday());
        modelAndView.addObject("registerDate", user.getRegisterDate());
        return modelAndView;
    }

    @GetMapping("/Modify")
    public String modify() {
        return "ModifyData";
    }

    @PostMapping("/ModifyData")
    public String updateData (User user,HttpSession session) {
        User user1 = (User) session.getAttribute("userInfo");
        user.setUserId(user1.getUserId());
        personalDataService.updateData(user);
        return "redirect:/personalData";
    }
}
