package cn.tjpu.microblog.service;


import cn.tjpu.microblog.dao.TagMapper;
import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TagService {
    @Resource
    private TagMapper tagMapper;

    //获取当前Tag信息
    public Tag getTagDescription(Integer tagId){
        List<Tag> tags =  tagMapper.getTagDescription(tagId);
        if(log.isInfoEnabled())
            log.info("Getting tag information {}", tags);
        return tags.get(0);
    }
    //获取当前tag页面的博客信息
    public List<Blog> getBlogsByTagId(Integer tagId){return tagMapper.getBlogsByTagId(tagId);}


}
