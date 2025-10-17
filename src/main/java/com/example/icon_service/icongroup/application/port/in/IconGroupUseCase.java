package com.example.icon_service.icongroup.application.port.in;

import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupRequest;
import com.example.icon_service.icongroup.adapter.dto.CreateIconGroupResponse;

public interface IconGroupUseCase {
	CreateIconGroupResponse createIconGroup(CreateIconGroupRequest createIconGroupRequest, final long memberId);
}
