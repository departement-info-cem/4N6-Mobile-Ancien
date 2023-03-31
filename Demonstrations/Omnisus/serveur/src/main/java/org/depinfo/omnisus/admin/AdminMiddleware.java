package org.depinfo.omnisus.admin;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminMiddleware implements HandlerInterceptor {

    @Autowired
    private Environment env;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().contains("admin")) {
            String adminHeader = request.getHeader("admin-password");
            if (adminHeader == null || !adminHeader.equals(env.getProperty("admin-password"))) {
                response.sendRedirect("https://youtu.be/dQw4w9WgXcQ?autoplay=1");
                return false;
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}