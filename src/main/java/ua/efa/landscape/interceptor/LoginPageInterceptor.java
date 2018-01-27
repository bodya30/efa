package ua.efa.landscape.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageInterceptor extends HandlerInterceptorAdapter {

    @Value("${enable.security}")
    private boolean isSecurityEnabled;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!isSecurityEnabled) {
            response.sendRedirect(request.getContextPath());
        }
        return true;
    }
}
