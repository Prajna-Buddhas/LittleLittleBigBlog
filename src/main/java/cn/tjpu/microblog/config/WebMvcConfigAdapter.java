package cn.tjpu.microblog.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置静态文件虚拟地址
 *
 * @author Trey
 * @since 2020/7/8
 */

@Configuration
public class ResourceConfigAdapter implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/avatar/**").addResourceLocations("file:/E:/Practice/avatar/");
        registry.addResourceHandler("/image/blogImg/**").addResourceLocations("file:/E:/Practice/blogImg/");
    }
}
