package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import cn.tjpu.microblog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客页面映射
 *
 * @author Trey
 * @since 2020/7/3
 */

@Repository
@Mapper
public interface ViewBlogMapper {

    // 查询浏览量
    @Select("SELECT pageviews FROM microblog_blog WHERE blog_id=#{blogId} ")
    Integer getPageView(Blog blog);

    // 查询点赞数

    @Select("SELECT likes FROM microblog_blog WHERE blog_id=#{blogId} ")
    Integer getLikes(Blog blog);

    // 点赞功能，点赞数+1
    @Update("UPDATE microblog_blog SET likes =likes +1 WHERE blog_id=#{blogId}")
    Integer addLike(Blog blog);

    // 点赞功能，点赞数-1
    @Update("UPDATE microblog_blog SET likes =likes -1 WHERE blog_id=#{blogId}")
    Integer reduceLike(Blog blog);

    @Select("SELECT * FROM microblog_user WHERE user_id = #{userId}")
    List<User> getUserByComment(Integer userId);

    @Select("SELECT username FROM microblog_user WHERE user_id = #{authorId}")
    String getAuthorName(Integer authorId);

    @Select("SELECT * FROM microblog_blog WHERE blog_id = #{blogId}")
    List<Blog> getBlog(Integer blogId);

    // 通过blogId查询所有评论
    @Select("SELECT * FROM microblog_comment WHERE blog_id = #{blogId}")
    List<Comment> findCommentById(Comment comment);

    // 发表评论
    @Insert("INSERT INTO microblog_comment (user_id, comment_content,comment_likes, blog_id)VALUES(#{userId}, #{commentContent},0, #{blogId})")
    Integer publishComment(Comment comment);

    @Select("SELECT tag_id FROM microblog_blog WHERE blog_id = #{blogId}")
    String getTagNameByBlogId(Integer blogId);

    // 相关推荐，查询相同tagId下的前8条数据
    @Select("SELECT * FROM microblog_blog WHERE tag_id=#{tagId} LIMIT 8")
    List<Blog> recommend(Blog blog);

    //评论点赞
    @Update("UPDATE microblog_comment SET comment_likes=comment_likes+1 WHERE comment_id=#{commentId}")
    Integer addCommentLike(Comment comment);

    // 回复评论(发表子评论)
    @Insert("INSERT INTO microblog_comment (user_id, comment_content, parent_comment_id,comment_likes, blog_id)VALUES(#{userId}, #{commentContent}, #{parentCommentId},0, #{blogId})")
    Integer addSubComment(Comment comment);
}
