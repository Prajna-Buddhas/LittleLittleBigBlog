package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录查询映射
 *
 * @author Trey
 * @since 2020/7/3
 */

@Mapper
@Repository
public interface LoginMapper {

    //todo 向microblog_user表查询用户密码
    @Select("")
    List<User> login();
}
