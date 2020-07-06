package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 注册查询映射
 *
 * @author Trey
 * @since 2020/7/3
 */
@Mapper
@Repository
public interface RegisterMapper {
    //todo 向microblog_user表插入user
    @Insert("INSERT INTO microblog_user (username,`password`,birthday,nickname,email,avatar_id) " +
            "VALUES (#{username},#{password},#{birthday},#{nickname},#{email},#{avatarId});")
    Integer registerUser(User user);
}
