package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Tag页的映射
 *
 * @author Trey
 * @since 2020/7/4
 */

@Mapper
@Repository
public interface TagMapper {

    //todo 查询当前tag信息
    @Select("SELECT * FROM microblog_tag WHERE tag_id = #{tagId};")
    List<Tag> getTagDescription(Tag tag);

    //todo 查询当前tag下所有blog
    @Select("SELECT title,content,release_date,blog_photo FROM microblog_blog WHERE tag_id = #{tagId}")
    List<Blog> getBlogsByTagId(Integer tagId);
}
