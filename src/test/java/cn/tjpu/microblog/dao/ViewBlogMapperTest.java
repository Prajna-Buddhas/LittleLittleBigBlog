package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.zip.ZipEntry;

/**
 * 浏览博客界面映射测试
 *
 * @author Trey
 * @since 2020/7/6
 */

@SpringBootTest
public class ViewBlogMapperTest {

    @Autowired
    ViewBlogMapper viewBlogMapper;

    @Test
    public void getLikes(){
        Blog blog=new Blog();
        blog.setBlogId(1);
        assert viewBlogMapper.getLikes(blog)==1;
    }
    @Test
    public void getPageView(){
        Blog blog=new Blog();
        blog.setBlogId(1);
        assert viewBlogMapper.getPageView(blog)==1;
    }
    @Test
    public void addLike(){
        Blog blog=new Blog();
        blog.setBlogId(1);
        assert viewBlogMapper.addLike(blog)==1;
    }
    @Test
    public void reduceLike(){
        Blog blog=new Blog();
        blog.setBlogId(1);
        assert viewBlogMapper.reduceLike(blog)==1;
    }


    @Test
    public void findCommentByIdTest() {
        Comment comment = new Comment();
        comment.setBlogId(1);
        List<Comment> list =  viewBlogMapper.findCommentById(comment);
        assert list.size() == 2;
    }

    @Test
    public void publishCommentTest() {
        Comment comment = new Comment();
        comment.setBlogId(2);
        comment.setCommentContent("我们中国真滴是太棒啦！");
        comment.setUserId(1);
        assert viewBlogMapper.publishComment(comment) == 1;
    }

    @Test
    public void recommendTest() {
        Blog blog = new Blog();
        blog.setTagId(2);
        List<Blog> blogs = viewBlogMapper.recommend(blog);
        assert blogs.size() == 1 && blogs.get(0).getBlogId() == 2;
    }

    @Test
    public void addCommentLikeTest() {
        Comment comment = new Comment();
        comment.setCommentId(1);
        assert viewBlogMapper.addCommentLike(comment) == 1;
    }

    @Test
    public void addSubCommentTest() {
        Comment comment = new Comment();
        comment.setBlogId(6);
        comment.setCommentContent("中国的蘸料，好吃！");
        comment.setUserId(2);
        comment.setParentCommentId(6);

        assert viewBlogMapper.addSubComment(comment) == 1;
    }



}
