package com.example.icon_service.auth.adapter.in.resolver;

import com.example.icon_service.auth.adapter.in.annotation.Login;
import com.example.icon_service.auth.domain.model.LoginMember;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoginMemberResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isMemberSessionType = parameter.getParameterType().equals(LoginMember.class);
        boolean isLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        return isMemberSessionType && isLoginAnnotation;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return request.getAttribute("LoginMember");
    }
}