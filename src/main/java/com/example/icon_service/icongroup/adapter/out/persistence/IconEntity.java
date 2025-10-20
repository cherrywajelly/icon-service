package com.example.icon_service.icongroup.adapter.out.persistence;

import com.example.icon_service.global.util.BaseTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "icon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IconEntity extends BaseTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "icon_id")
	private long id;

	private String iconImageUrl;

	@Builder
	public IconEntity(final String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
}
