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
    public void getTagDescription(Integer tagId) {
        List<Tag>  list = tagMapper.getTagDescription(tagId);
        assert list.get(0).getTagName().equals("美食");
    }

    @Test
    public void getBlogsByTagId(Integer tagId) {
        List<Blog>  list = tagMapper.getBlogsByTagId(tagId);
        assert list.size() == 1;
    }
}
