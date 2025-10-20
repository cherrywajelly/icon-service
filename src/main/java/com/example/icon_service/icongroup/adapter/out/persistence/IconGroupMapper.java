package com.example.icon_service.icongroup.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.icon_service.icongroup.domain.model.IconGroup;

@Component
public class IconGroupMapper {

	public static IconGroupEntity toEntity(IconGroup iconGroup) {
		return IconGroupEntity.builder()
			.memberId(iconGroup.getMemberId())
			.name(iconGroup.getName())
			.description(iconGroup.getDescription())
			.price(iconGroup.getPrice())
			.iconType(iconGroup.getIconType())
			.iconBuiltin(iconGroup.getIconBuiltin())
			.iconState(iconGroup.getIconState())
			.build();
	}

	public static IconGroup toDomain(IconGroupEntity iconGroupEntity) {
		return IconGroup.builder()
			.id(iconGroupEntity.getId())
			.memberId(iconGroupEntity.getMemberId())
			.name(iconGroupEntity.getName())
			.description(iconGroupEntity.getDescription())
			.price(iconGroupEntity.getPrice())
			.iconType(iconGroupEntity.getIconType())
			.iconBuiltin(iconGroupEntity.getIconBuiltin())
			.iconState(iconGroupEntity.getIconState())
			.build();
	}
}
