package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.User;

import java.util.List;

/**
 * adminMapper
 *
 * @author Trey
 * @since 2020/7/11
 */
public interface AdminMapper {

    List<Blog> getAllBlogs();

    List<User> getAllUsers();

    Integer updateBlog(Blog blog);

    Integer updateUser(User user);

    List<User> adminLogin(User user);

}
