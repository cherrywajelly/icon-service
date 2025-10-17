package com.example.icon_service.icongroup.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.icon_service.auth.adapter.in.annotation.Login;
import com.example.icon_service.auth.domain.model.LoginMember;
import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupRequest;
import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupResponse;
import com.example.icon_service.icongroup.application.port.in.IconGroupUseCase;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/icon/v2/iconGroups")
@RestController
@RequiredArgsConstructor
public class IconGroupController {

	private final IconGroupUseCase iconGroupUseCase;

	@PostMapping("")
	public CreateIconGroupResponse createIconGroup(@Login LoginMember loginMember, @RequestBody CreateIconGroupRequest createIconGroupRequest) {
		return iconGroupUseCase.createIconGroup(createIconGroupRequest, loginMember.id());
	}
}
