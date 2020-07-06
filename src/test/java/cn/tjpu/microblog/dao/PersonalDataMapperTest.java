package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PersonalDataMapperTest{
    @Resource
    PersonalDataMapper personalDataMapper;

    @Test
    public void getuser(){
        User user = new User();
        user.setUserId(2);
        List<User> list = personalDataMapper.getUser(user);
        assert "ll".equals(list.get(0).getUsername()) ;
    }
}
