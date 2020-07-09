package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈沿儒
 * @date 2020/7/6 - 11:14
 */

@SpringBootTest
public class RegisterMapperTest {
    @Autowired
    RegisterMapper registerMapper;

    @Test
    public void setRegisterMapperTest() throws ParseException {
        User user = new User();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat1.parse("1988-06-01");
        user.setBirthday(birthday);
        user.setUsername("老八");
        user.setPassword("奥力给");
        user.setNickname("八八");
        user.setEmail("123456789@qq.com");
        assert registerMapper.registerUser(user) == 1;
    }
}