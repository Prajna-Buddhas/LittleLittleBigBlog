package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * @author 陈沿儒
 * @date 2020/7/4 - 11:47
 */

@SpringBootTest
public class PublishBlogMapperTest {

    @Autowired
    PublishBlogMapper publishBlogMapper;

    @Test
    public void PublishBlogMapperTest () {
        Blog blog = new Blog();
        blog.setTitle("老八美食");
        blog.setContent("扒鸭屁股是块宝");
        blog.setTagId(3);
        blog.setBlogPhoto("qweqweqr");
        blog.setAuthorId(2);
        assert publishBlogMapper.publishBlog(blog) == 1;
    }
}
