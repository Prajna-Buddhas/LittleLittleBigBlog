package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * adminMapper
 *
 * @author Trey
 * @since 2020/7/11
 */

@Mapper
@Repository
public interface AdminMapper {

    @Select("SELECT * FROM microblog_blog;")
    List<Blog> getAllBlogs();

    @Select("SELECT * FROM microblog_user;")
    List<User> getAllUsers();

    @Update("UPDATE microblog_blog SET title = #{title}, content = #{content} ,blog_photo = #{blogPhoto} WHERE blog_id = #{blogId} ;")
    Integer updateBlog(Blog blog);

    @Update("UPDATE microblog_user SET password = #{password}, nickname = #{nickname}, username = #{username}, email = #{email}, birthday = #{birthday}, avatar_id = #{avatarId} WHERE user_id = #{userId};")
    Integer updateUser(User user);

    @Select("SELECT * FROM microblog_user WHERE username = #{username}")
    List<User> adminLogin(User user);

    @Delete("DELETE FROM microblog_blog WHERE blog_id = #{blogId};")
    Integer deleteBlog(Blog blog);

    @Delete("DELETE FROM microblog_user WHERE user_id = #{userId};")
    Integer deleteUser(User user);

}
