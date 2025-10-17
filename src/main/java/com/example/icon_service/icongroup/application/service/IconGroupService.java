package com.example.icon_service.icongroup.application.service;

import org.springframework.stereotype.Service;

import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupRequest;
import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupResponse;
import com.example.icon_service.icongroup.application.port.in.IconGroupUseCase;
import com.example.icon_service.icongroup.application.port.out.IconGroupPersistencePort;
import com.example.icon_service.icongroup.domain.model.IconGroup;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IconGroupService implements IconGroupUseCase {

	private final IconGroupPersistencePort iconGroupPersistencePort;

	public IconGroupService(IconGroupPersistencePort iconGroupPersistencePort) {
		this.iconGroupPersistencePort = iconGroupPersistencePort;
	}

	@Override
	public CreateIconGroupResponse createIconGroup(CreateIconGroupRequest createIconGroupRequest, final long creatorId) {

		IconGroup iconGroup = createIconGroupRequest.to(creatorId);

		return CreateIconGroupResponse.from(iconGroupPersistencePort.save(iconGroup));
	}
}
