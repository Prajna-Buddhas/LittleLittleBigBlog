package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/personalData")
    public ModelAndView getPersonalData(ModelAndView modelAndView, HttpSession session) {
        return modelAndView;
    }
}
