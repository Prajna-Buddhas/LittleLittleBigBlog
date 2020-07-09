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

    public List<Blog> getIndexRecommend(Blog blog) {
        Blog mainBlog = indexMapper.getIndexRecommend(blog.getBlogId()).get(0);
        if (mainBlog != null){
            return indexMapper.getIndexRecommend(mainBlog);
        }
        if(log.isErrorEnabled())
            log.error("can't get recommendation by blogId {}", blog.getBlogId());
        throw new RuntimeException("can't get recommendation");
    }
    public String getAuthorName(Integer authorId) {
        return indexMapper.getAuthorName(authorId);
    }




}
