package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.LoginMapper;
import cn.tjpu.microblog.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * LoginService
 *
 * @author Trey
 * @since 2020/7/10
 */

@Service
public class LoginService {

    @Resource
    LoginMapper mapper;

    public String login(User user, HttpServletRequest request) {
        String password = user.getPassword();

        List<User> users = mapper.login(user);
        if (users.size() == 0) {
            return "用户不存在";
        }

        User dataUser = users.get(0);
        String dataPassword = dataUser.getPassword();
        if (dataPassword.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", dataUser);
            return "success";
        } else {
            return "密码错误";
        }

    }
}
