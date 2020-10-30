package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Order;
import org.apache.catalina.User;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class Filter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Order order = (Order)request.getSession().getAttribute("order");

        String path = request.getServletPath();

        if (!"/".equals(path) && !"".equals(path) && order==null) {
            response.sendRedirect("");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
