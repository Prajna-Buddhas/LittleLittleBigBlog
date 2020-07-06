package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 主页的查询映射
 *
 * @author Trey
 * @since 2020/7/4
 */

@Mapper
@Repository
public interface IndexMapper {

    //todo 查询所有tag，轮播图
    @Select("SELECT tag_name FROM microblog_tag")
    List<Tag> getRotationChart(Tag tag);

    //todo 首页推荐，查看最新发布的10条博客
    @Select("SELECT title,content,release_date,blog_photo FROM microblog_blog ORDER BY release_date DESC LIMIT 10")
    List<Blog> getIndexRecommend(Blog blog);

}
