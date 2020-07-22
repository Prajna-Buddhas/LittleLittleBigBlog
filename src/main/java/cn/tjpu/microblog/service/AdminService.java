package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.AdminMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * adminService
 *
 * @author Trey
 * @since 2020/7/11
 */

@Service
@Slf4j
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    public String adminLogin(User user, HttpServletRequest request) {
        List<User> dataUsers = adminMapper.adminLogin(user);

        if (dataUsers.size() == 0) {
            if (log.isInfoEnabled()) {
                log.info("can't find user {}",user.getUsername());
            }
            return "用户不存在";
        }
        User dataUser = dataUsers.get(0);
        String dataPassword = dataUser.getPassword();
        if (!dataPassword.equals(user.getPassword())) {
            return "密码错误";
        }
        Integer admin = dataUser.getAdmin();
        if (admin != 1) {
            return "管理员权限不足";
        }

        request.getSession().setAttribute("admin",dataUser);
        return "success";
    }

    public List<User> getAllUsers() {
        return adminMapper.getAllUsers();
    }

    public List<Blog> getAllBlogs() {
        return adminMapper.getAllBlogs();
    }

    public void updateUser(User user) {
        adminMapper.updateUser(user);
    }

    public void deleteUser(User user) {
        adminMapper.deleteUser(user);
    }

    public void updateBlog(Blog blog) {
        adminMapper.updateBlog(blog);
    }

    public void deleteBlog(Blog blog) {
        adminMapper.deleteBlog(blog);
    }
}
