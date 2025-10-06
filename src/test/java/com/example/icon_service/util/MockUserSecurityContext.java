package com.example.icon_service.util;

import com.example.icon_service.auth.domain.enums.MemberRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

public class MockUserSecurityContext implements WithSecurityContextFactory<MockUser> {
    @Override
    public SecurityContext createSecurityContext(MockUser annotation) {
        final SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + MemberRole.USER.name()));
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(1L, null, authorities);

        securityContext.setAuthentication(authentication);
        return securityContext;
    }
}
