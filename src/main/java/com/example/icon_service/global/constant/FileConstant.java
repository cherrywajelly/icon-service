package com.example.icon_service.global.constant;

public enum FileConstant {
	ICON("icon"),
	ICON_GROUP("iconGroup"),
	IMAGE("image");

	private final String value;

	FileConstant(final String value) {
		this.value = value;
	}

	public String value(){
		return value;
	}
}
