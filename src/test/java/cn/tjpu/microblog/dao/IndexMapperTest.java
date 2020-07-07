package cn.tjpu.microblog.dao;

import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class IndexMapperTest {

    @Resource
    IndexMapper indexMapper;

    @Test
    public void getRotationChart() {
        Tag tag = new Tag();
        tag.setTagName("美食");
        List<Tag> list = indexMapper.getRotationChart(tag);
        assert list.size() == 4;
    }

   @Test
    public void getIndexRecommend(){
       Blog blog = new Blog();

       List<Blog> list = indexMapper.getIndexRecommend(blog);
       assert list.size() == 2;

   }
}
