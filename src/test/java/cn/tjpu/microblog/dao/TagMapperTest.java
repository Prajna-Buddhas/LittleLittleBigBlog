package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 陈沿儒
 * @date 2020/7/6 - 11:16
 */
@SpringBootTest
public class TagMapperTest {
    @Autowired
    TagMapper tagMapper;

    @Test
    public void getTagDescription() {
        Tag tag = new Tag();
        tag.setTagId(1);
        List<Tag>  list = tagMapper.getTagDescription(tag.getTagId());
        assert list.get(0).getTagName().equals("美食");
    }

    @Test
    public void getBlogsByTagId() {
        Blog blog = new Blog();
        blog.setTagId(2);
        List<Blog>  list = tagMapper.getBlogsByTagId(2);
        assert list.size() == 1;
    }
}
