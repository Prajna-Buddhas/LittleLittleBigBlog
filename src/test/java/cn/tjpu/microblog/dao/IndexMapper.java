package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

@SpringBootTest
class IndexMapperTest {

    @Autowired
    IndexMapper indexMapper;

    @Test
    public void getRotationChart() {
        Tag tag = new Tag();
        tag.setTagName("美食");
        List<Tag> list = indexMapper.getRotationChart();
        assert list.size() == 2;
   }

  /* @Test
    public void getIndexRecommend(){
       Blog blog = new Blog();
       blog.getBlogId();
       blog.getBlogPhoto();
       blog.getTitle();
       blog.getReleaseDate();
       List<Blog> list = indexMapper.getIndexRecommend();
       assert list.size() == 2;*/

   }
}