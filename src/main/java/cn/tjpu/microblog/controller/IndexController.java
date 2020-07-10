package cn.tjpu.microblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Trey
 * @since 2020/7/10
 */

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
