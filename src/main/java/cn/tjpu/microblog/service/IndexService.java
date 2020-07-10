package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.IndexMapper;
import cn.tjpu.microblog.domain.Blog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;




@Slf4j
@Service
public class IndexService {
    @Resource
    private IndexMapper indexMapper;

    public List<Blog> getIndexRecommend() {

        return indexMapper.getIndexRecommend();

    }

}
