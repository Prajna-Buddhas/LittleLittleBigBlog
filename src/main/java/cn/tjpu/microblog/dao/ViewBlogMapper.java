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

    //todo 查询当前博客id下的所有评论id，再通过评论id查询出所有评论
    @Select("")
    List<Comment> getComments(Blog blog);

    //todo 发表评论
    @Insert("")
    Integer publishComment(Comment comment);

    //todo 相关推荐，查询相同tagId下的前8条数据
    List<Blog> recommend(Blog blog);

    //todo 评论点赞
    @Update("")
    Integer addCommentLike();

    //todo 回复评论(发表子评论)
    @Insert("")
    Integer addSubComment(Comment comment);
}
