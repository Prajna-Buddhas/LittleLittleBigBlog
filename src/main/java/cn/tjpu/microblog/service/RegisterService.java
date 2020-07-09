package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.RegisterMapper;
import cn.tjpu.microblog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * @author 陈沿儒
 * @date 2020/7/8 - 15:41
 */

@Slf4j
@Service
public class RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    public void register(User user) {
        if ("".equals(user.getUsername()) || "".equals(user.getPassword()) || "".equals(user.getEmail()) || "".equals(user.getNickname()) || user.getBirthday() == null) {
            if (log.isInfoEnabled())
                log.info("can't find user by getUsername{},getPassword{},getEmail{},getNickname{},getBirthday{}",user.getPassword(),user.getPassword(),user.getEmail(),user.getNickname(),user.getBirthday());
            throw new RuntimeException("can't find user ");
        } else {
            registerMapper.registerUser(user);
        }
    }
}
