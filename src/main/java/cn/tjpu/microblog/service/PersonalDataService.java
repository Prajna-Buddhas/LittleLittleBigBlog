package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 陈沿儒
 * @date 2020/7/10 - 18:21
 */

@Slf4j
@Service
public class PersonalDataService {
    @Resource
    private PersonalDataMapper personalDataMapper;
    @Resource
    HttpSession session;

    public void updateData(User user) {
        personalDataMapper.updateByUserId(user);
        session.removeAttribute("userInfo");
        List<User> users = personalDataMapper.getUser(user);
        session.setAttribute("userInfo",users.get(0));
    }
}
