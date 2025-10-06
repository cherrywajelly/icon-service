package com.example.icon_service.util;

import com.example.icon_service.auth.domain.enums.MemberRole;
import com.example.icon_service.auth.domain.model.LoginMember;
import jakarta.servlet.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class MockSpringSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setAttribute("LoginMember", LoginMember.builder().id(1).role(MemberRole.USER).build());
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        SecurityContextHolder.clearContext();
    }
//    public void getFilters(MockHttpServletRequest mockHttpServletRequest){}

}
