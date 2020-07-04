package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 博客页面映射
 *
 * @author Trey
 * @since 2020/7/3
 */

@Mapper
public interface ViewBlogMapper {

    //todo 查询浏览量
    @Select("")
    Integer getPageView(Blog blog);

    //todo 查询点赞数
    @Select("")
    Integer getLikes(Blog blog);

    //todo 点赞功能，点赞数+1
    @Update("")
    Integer addLike(Blog blog);

    //todo 点赞功能，点赞数-1
    @Update("")
    Integer reduceLike(Blog blog);

    // 通过blogId查询所有评论
    @Select("SELECT * FROM microblog_comment WHERE blog_id = #{blogId}")
    List<Comment> findCommentById(Comment comment);

    // 发表评论
    @Insert("INSERT INTO microblog_comment (user_id, comment_content, blog_id)VALUES(#{userId}, #{commentContent}, #{blogId})")
    Integer publishComment(Comment comment);

    // 相关推荐，查询相同tagId下的前8条数据
    @Select("SELECT * FROM microblog_blog WHERE tag_Id=#{tagId} LIMIT 8")
    List<Blog> recommend(Blog blog);

    //评论点赞
    @Update("UPDATE microblog_comment SET comment_likes=#{commentLikes} WHERE comment_id=#{commentId}")
    Integer addCommentLike(Comment comment);

    // 回复评论(发表子评论)
    @Insert("INSERT INTO microblog_comment (user_id, comment_content, parent_comment_id, blog_id)VALUES(#{userId}, #{commentContent}, #{parentCommentId}, #{blogId})")
    Integer addSubComment(Comment comment);
}
