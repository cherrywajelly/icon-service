package com.example.icon_service.auth.adapter.in;

import com.example.icon_service.auth.adapter.in.annotation.Login;
import com.example.icon_service.auth.domain.model.LoginMember;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/icon/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("")
    public void testAuth(@Login LoginMember loginMember){
        System.out.println(loginMember.id());
        System.out.println(loginMember.role());
    }
}
