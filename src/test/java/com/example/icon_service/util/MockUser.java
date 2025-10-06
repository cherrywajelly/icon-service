package com.example.icon_service.util;

import com.example.icon_service.auth.domain.enums.MemberRole;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = MockUserSecurityContext.class)
public @interface MockUser {

    long userId() default 1;
    String userEmail() default "test email";
    String userNickname() default "test nickname";
    MemberRole userRole() default MemberRole.USER;

}
