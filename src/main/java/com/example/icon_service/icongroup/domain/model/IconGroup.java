package com.example.icon_service.icongroup.domain.model;

import java.util.List;

import com.example.icon_service.icongroup.domain.enums.IconBuiltin;
import com.example.icon_service.icongroup.domain.enums.IconState;
import com.example.icon_service.icongroup.domain.enums.IconType;

import lombok.Builder;
import lombok.Getter;

@Getter
public class IconGroup {

	private final long id;
	private final Long memberId;
	private final String name;
	private final String description;
	private final int price;
	private final IconType iconType;
	private final IconBuiltin iconBuiltin;
	private final IconState iconState;
	private String thumbnailImageUrl;
	private List<Icon> icons;


	@Builder
	public IconGroup(final long id, final Long memberId, final String name, final String description, final int price,
		final IconType iconType, final IconBuiltin iconBuiltin, final IconState iconState){
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.iconType = iconType;
		this.iconBuiltin = iconBuiltin;
		this.iconState = iconState;
	}
}


