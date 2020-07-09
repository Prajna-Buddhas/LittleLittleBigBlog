package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.PublishBlogMapper;
import cn.tjpu.microblog.domain.Blog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 陈沿儒
 * @date 2020/7/8 - 10:06
 */

@Slf4j
@Service
public class PublishBlogService {
    @Resource
    private PublishBlogMapper publishBlogMapper;

    public void PublishBlog(Blog blog , HttpSession session) {
        Integer integer = (Integer) session.getAttribute("userId");
//        blog.setAuthorId(integer);
        if ("".equals(blog.getTitle()) || "".equals(blog.getContent())) {
            if (log.isInfoEnabled())
                log.info("can't publish blog");
                throw new RuntimeException("can't publish blog ");
        } else {
            publishBlogMapper.publishBlog(blog);
        }
    }
}
