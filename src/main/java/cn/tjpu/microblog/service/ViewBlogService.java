package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.ViewBlogMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ViewBlogService
 *
 * @author Trey
 * @since 2020/7/6
 */

@Service
public class ViewBlogService {

    @Resource
    private ViewBlogMapper viewBlogMapper;

    //获取博客信息
    public Blog getBlog(Integer blogId) {
        List<Blog> blogs = viewBlogMapper.getBlog(blogId);
        return blogs.get(0);
    }

    //获取所有评论
    public List<Comment> getComments(Integer id) {
        Comment comment = new Comment();
        comment.setBlogId(id);
        return viewBlogMapper.findCommentById(comment);
    }

    //获取相关推荐
    public List<Blog> getRecommend(Blog blog) {
        return viewBlogMapper.recommend(blog);
    }

    public Integer publishComment(Comment comment) {
        return viewBlogMapper.publishComment(comment);
    }

    public Integer publishReply(Comment comment) {
        return viewBlogMapper.addSubComment(comment);
    }

    public String getAuthorName(Integer authorId) {
        return viewBlogMapper.getAuthorName(authorId);
    }
}
