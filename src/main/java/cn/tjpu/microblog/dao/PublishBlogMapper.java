package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 发表博客映射
 *
 * @author Trey
 * @since 2020/7/4
 */

@Mapper
@Repository
public interface PublishBlogMapper {

    //todo 发表博客
    @Insert("INSERT INTO microblog_blog (title,content,tag_id,blog_photo,author_id,likes,pageviews,comment_count)" +
            "VALUES (#{title},#{content},#{tagId},#{blogPhoto},#{authorId},0,0,0);")
    Integer publishBlog(Blog blog);
}
