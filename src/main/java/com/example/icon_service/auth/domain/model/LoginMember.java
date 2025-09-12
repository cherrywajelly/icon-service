package com.example.icon_service.auth.domain.model;

import com.example.icon_service.auth.domain.enums.MemberRole;
import lombok.Builder;

@Builder
public record LoginMember(
        long id,
        MemberRole role
) {

}