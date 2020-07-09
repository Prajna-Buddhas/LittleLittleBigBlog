package cn.tjpu.microblog.service;


import cn.tjpu.microblog.dao.TagMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class TagService {
    @Resource
    private TagMapper tagMapper;

    //获取当前Tag信息
    public Tag getTagDescription(Tag tag){
        List<Tag> tags =  tagMapper.getTagDescription(tag);
        if(log.isInfoEnabled())
            log.info("Getting tag information {}", tags);
        return tags.get(0);
    }
    //获取当前tag页面的博客信息
    public Tag getBlogsByTagId(Blog blog){return tagMapper.getBlogsByTagId(tagId);}

    public Map<String, Object> (Comment comment) {
        Map<String, Object> tagMap = new HashMap<>();
        String username = getBlogsByTagId(blog.get);

        if ("".equals(username) || username == null) {
            if (log.isInfoEnabled())
                log.info("can't find user by userId{}", comment.getUserId());
        }   else {
            commentMap.put("username", getUsernameByComment(comment.getUserId())) ;
            commentMap.put("comment",comment);
        }
        return commentMap;
    }

}
