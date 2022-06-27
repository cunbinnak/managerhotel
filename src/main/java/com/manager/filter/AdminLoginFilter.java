package com.manager.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminLoginFilter")
public class AdminLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if(session.getAttribute("username") == null
                && !req.getRequestURI().endsWith("/authen/login")
                && (session.getAttribute("role") == null || !session.getAttribute("role").equals("ADMIN"))){
            res.sendRedirect("/manager_hotel_war/authen/login");
        } else {
                chain.doFilter(request, response);
        }

    }

}
