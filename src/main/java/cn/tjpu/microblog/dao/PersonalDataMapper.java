package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PersionalDataMapper
 *
 * @author Trey
 * @since 2020/7/4
 */
@Mapper
@Repository
public interface PersonalDataMapper {

    //todo 查询单个用户信息
    @Select(" SELECT * FROM microblog_user WHERE user_id = #{userId} ")
    List<User> getUser(User user);

    @Update("UPDATE microblog_user SET nickname = #{nickname}, username = #{username}, email = #{email}, birthday = #{birthday}, avatar_id = #{avatarId} WHERE user_id = #{userId};")
    Integer updateByUserId(User user);
}
