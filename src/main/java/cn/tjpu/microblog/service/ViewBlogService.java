package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.ViewBlogMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import cn.tjpu.microblog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ViewBlogService
 *
 * @author Trey
 * @since 2020/7/6
 */

@Slf4j
@Service
public class ViewBlogService {
    @Resource
    private ViewBlogMapper viewBlogMapper;

    //获取博客信息
    public Blog getBlog(Integer blogId) {
        List<Blog> blogs = viewBlogMapper.getBlog(blogId);
        if(log.isInfoEnabled())
            log.info("Getting blog information {}", blogs);
        return blogs.get(0);
    }

    //获取所有评论
    public List<Comment> getComments(Integer id) {
        Comment comment = new Comment();
        comment.setBlogId(id);
        List<Comment> comments = viewBlogMapper.findCommentById(comment);
        if (log.isInfoEnabled())
            log.info("Getting comments under blog{},{} results found", id,comments.size());
        return comments;
    }

    //通过评论的userId获取username
    public String getUsernameByComment(Integer userId) {
        return viewBlogMapper.getUsernameByComment(userId);
    }

    public Map<String, Object> commentConstructor(Comment comment) {
        Map<String, Object> commentMap = new HashMap<>();
        String username = getUsernameByComment(comment.getUserId());

        if ("".equals(username) || username == null) {
            if (log.isInfoEnabled())
                log.info("can't find user by userId{}", comment.getUserId());
        }   else {
            commentMap.put("username", getUsernameByComment(comment.getUserId())) ;
            commentMap.put("comment",comment);
        }
            return commentMap;
    }

    //获取相关推荐
    public List<Blog> getRecommend(Blog blog) {
        Blog mainBlog = viewBlogMapper.getBlog(blog.getBlogId()).get(0);
        if (mainBlog != null){
            return viewBlogMapper.recommend(mainBlog);
        }
        if (log.isErrorEnabled())
            log.error("can't get recommendation by blogId {}", blog.getBlogId());
        throw new RuntimeException("can't get recommendation");
    }

    public String getAuthorName(Integer authorId) {
        return viewBlogMapper.getAuthorName(authorId);
    }

    public void publishComment(Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("userInfo");
        comment.setUserId(user.getUserId());
        viewBlogMapper.publishComment(comment);
    }
}
