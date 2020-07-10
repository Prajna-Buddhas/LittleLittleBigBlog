package cn.tjpu.microblog.config;

import cn.tjpu.microblog.component.LoginHandleInterception;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置静态文件虚拟地址
 *
 * @author Trey
 * @since 2020/7/8
 */

@Configuration
public class WebMvcConfigAdapter implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/avatar/**").addResourceLocations("file:/E:/Practice/avatar/");
        registry.addResourceHandler("/image/blogImg/**").addResourceLocations("file:/E:/Practice/blogImg/");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandleInterception()).addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/register");
            }
        };
    }
}
