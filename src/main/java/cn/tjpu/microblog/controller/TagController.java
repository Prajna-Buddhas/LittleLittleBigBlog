package cn.tjpu.microblog.controller;


import cn.tjpu.microblog.domain.Tag;
import cn.tjpu.microblog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class TagController {
    @Resource
    TagService service;

    @GetMapping("/tag/{id}")
    public ModelAndView ViewBlog(@PathVariable("id")Tag tag, ModelAndView modelAndView) {
        modelAndView.("Tag");
        Tag tag = service.getTagDescription(tag);
        modelAndView.addObject("tag", tag);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping



}
