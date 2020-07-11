package cn.tjpu.microblog.config;

import cn.tjpu.microblog.component.LoginHandleInterception;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 设置静态文件虚拟地址
 *
 * @author Trey
 * @since 2020/7/8
 */

@Configuration
public class WebMvcConfigAdapter implements WebMvcConfigurer {

    @Resource
    LoginHandleInterception loginHandleInterception;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/avatar/**").addResourceLocations("file:/E:/Practice/avatar/");
        registry.addResourceHandler("/image/blogImg/**").addResourceLocations("file:/E:/Practice/blogImg/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandleInterception).addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/register","/register.html","/css/**","/js/**","/img/**");
    }
}
