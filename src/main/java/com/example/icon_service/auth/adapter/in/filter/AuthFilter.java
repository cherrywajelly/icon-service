package com.example.icon_service.auth.adapter.in.filter;

import com.example.icon_service.auth.domain.enums.MemberRole;
import com.example.icon_service.auth.domain.model.LoginMember;
import com.example.icon_service.global.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static com.example.icon_service.global.constant.ExceptionConstant.INVALID_TOKEN_FORMAT;

@Slf4j
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String userId = request.getHeader("X-User-Id");
        String role = request.getHeader("X-User-Role");

        if(userId != null && role != null){
            long id = Long.parseLong(userId);

            try {
                MemberRole memberRole = MemberRole.valueOf(role.toUpperCase());

                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userId, null, authorities);

                request.setAttribute("LoginMember", LoginMember.builder().id(id).role(memberRole).build());
                MDC.put("userId", userId);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                throw new UnauthorizedException(INVALID_TOKEN_FORMAT.message());
            }

        }

        filterChain.doFilter(request, response);
    }

}

