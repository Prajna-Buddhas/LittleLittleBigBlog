package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.util.Password;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginMapperTest {

    @Resource
    LoginMapper loginMapper;

    @Test
    public void login(){
        User user = new User();
        user.setUsername("ll");
        List<User> list = loginMapper.login(user);

        assert "woshill".equals(list.get(0).getPassword()) ;
    }

        }