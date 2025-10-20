package com.example.icon_service.icongroup.adapter.dto;

import com.example.icon_service.icongroup.domain.enums.IconBuiltin;
import com.example.icon_service.icongroup.domain.enums.IconState;
import com.example.icon_service.icongroup.domain.enums.IconType;
import com.example.icon_service.icongroup.domain.model.IconGroup;

public record CreateIconGroupRequest(
	String name,
	String description,
	int price,
	IconType iconType

) {
	public IconGroup to(final long creatorId) {
		return IconGroup.builder()
			.memberId(creatorId)
			.name(name)
			.description(description)
			.price(price)
			.iconType(iconType)
			.iconBuiltin(IconBuiltin.NONBUILTIN)
			.iconState(IconState.WAITING)
			.build();
	}
}
