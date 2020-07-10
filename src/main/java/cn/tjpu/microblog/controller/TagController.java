package cn.tjpu.microblog.controller;


import cn.tjpu.microblog.domain.Blog;
import cn.tjpu.microblog.domain.Tag;
import cn.tjpu.microblog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TagController {
    @Resource
    TagService service;

    @GetMapping("/tag/{id}")
    public ModelAndView Tag(@PathVariable("id")Integer tagId, ModelAndView modelAndView) {
        modelAndView.setViewName("tag");
        Tag tag = service.getTagDescription(tagId);
        modelAndView.addObject("tag", tag);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/tag/{id}/blogs")
    public List<Blog> getBlogsByTagId(@PathVariable("id") Integer tagId){
        Tag tag = new Tag();
        tag.setTagId(tagId);
        return service.getBlogsByTagId(tagId);

    }


}
