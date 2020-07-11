package cn.tjpu.microblog.controller;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.service.PersonalDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public String getPersonalData(ModelAndView modelAndView, HttpSession session) {
        return "PersonalData";
    }

    @GetMapping("/Modify")
    public String modify() {
        return "ModifyData";
    }

    @PostMapping("/ModifyData")
    public String updateData (User user, HttpSession session , @RequestParam("uploadAvatarImg")MultipartFile file) throws IOException {
        User user1 = (User) session.getAttribute("userInfo");
        user.setUserId(user1.getUserId());
        personalDataService.updateData(user, file);
        return "redirect:/personalData";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("userInfo");
        return "/index";
    }
}
