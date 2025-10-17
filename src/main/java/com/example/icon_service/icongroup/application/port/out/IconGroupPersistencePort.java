package com.example.icon_service.icongroup.application.port.out;

import com.example.icon_service.icongroup.domain.model.IconGroup;

public interface IconGroupPersistencePort {
	IconGroup save(IconGroup iconGroup);
}
