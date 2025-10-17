package com.example.icon_service.icongroup.adapter.dto;

import com.example.icon_service.icongroup.domain.enums.IconState;
import com.example.icon_service.icongroup.domain.enums.IconType;
import com.example.icon_service.icongroup.domain.model.IconGroup;

import lombok.Builder;

@Builder
public record CreateIconGroupResponse(
	long iconGroupId,
	String name,
	String description,
	int price,
	IconType iconType,
	IconState iconState
	//tODO String thumbnailImageUrl

) {

	public static CreateIconGroupResponse from(final IconGroup iconGroup) {
		return CreateIconGroupResponse.builder()
			.iconGroupId(iconGroup.getId())
			.name(iconGroup.getName())
			.description(iconGroup.getDescription())
			.price(iconGroup.getPrice())
			.iconType(iconGroup.getIconType())
			.iconState(iconGroup.getIconState())
			//TODO .thumbnailImageUrl(iconGroup.getThumbnailImageUrl())
			.build();
	}
}
