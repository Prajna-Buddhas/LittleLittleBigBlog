package cn.tjpu.microblog.component;

import cn.tjpu.microblog.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 *
 * @author Trey
 * @since 2020/7/10
 */

@Slf4j
public class LoginHandleInterception implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userInfo = "userInfo";
        User user = (User) request.getSession().getAttribute(userInfo);
        if (user == null) {
            if (log.isDebugEnabled()) {
                log.debug("Not logged in!");
            }
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
