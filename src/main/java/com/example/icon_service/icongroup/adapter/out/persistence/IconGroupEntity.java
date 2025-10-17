package com.example.icon_service.icongroup.adapter.out.persistence;

import java.util.List;

import com.example.icon_service.global.util.BaseTime;
import com.example.icon_service.icongroup.domain.enums.IconBuiltin;
import com.example.icon_service.icongroup.domain.enums.IconState;
import com.example.icon_service.icongroup.domain.enums.IconType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "icon_group")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IconGroupEntity extends BaseTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "icon_group_id")
	private long id;

	private Long memberId;

	@Column(nullable = false)
	private String name;

	private String description;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private IconType iconType;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private IconBuiltin iconBuiltin;

	@Enumerated(EnumType.STRING)
	private IconState iconState;

	private String thumbnailImageUrl;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "icon_group_id")
	private List<IconEntity> icons;

	@Builder
	public IconGroupEntity (final long memberId, final String name, final String description,
		final int price, final IconType iconType, final IconBuiltin iconBuiltin, final IconState iconState) {
		this.memberId = memberId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.iconType = iconType;
		this.iconBuiltin = iconBuiltin;
		this.iconState = iconState;
	}

}
