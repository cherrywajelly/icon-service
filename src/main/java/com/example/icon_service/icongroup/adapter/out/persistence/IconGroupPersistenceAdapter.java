package com.example.icon_service.icongroup.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.example.icon_service.icongroup.application.port.out.IconGroupPersistencePort;
import com.example.icon_service.icongroup.domain.model.IconGroup;

@Repository
public class IconGroupPersistenceAdapter implements IconGroupPersistencePort {

	private final IconGroupJpaRepository iconGroupJpaRepository;

	public IconGroupPersistenceAdapter(IconGroupJpaRepository iconGroupJpaRepository) {
		this.iconGroupJpaRepository = iconGroupJpaRepository;
	}

	@Override
	public IconGroup save(final IconGroup iconGroup) {
		IconGroupEntity iconGroupEntity = iconGroupJpaRepository.save(IconGroupMapper.toEntity(iconGroup));
		return IconGroupMapper.toDomain(iconGroupEntity);
	}
}
