package ua.efa.landscape.filter;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ConfigurableDelegatingFilterProxy extends DelegatingFilterProxy {

    private final static String ENABLE_SPRING_SECURITY = "enable.security";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean isSecurityEnabled = Boolean.parseBoolean(request.getServletContext().getInitParameter(ENABLE_SPRING_SECURITY));
        if (isSecurityEnabled) {
            super.doFilter(request, response, filterChain);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
