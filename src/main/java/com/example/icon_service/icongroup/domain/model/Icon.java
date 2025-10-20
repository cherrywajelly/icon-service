package com.example.icon_service.icongroup.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Icon {

    private final long id;
    private final Long iconGroupId;
    private final String iconImageUrl;

    @Builder
    public Icon (final long id, final long iconGroupId, final String iconImageUrl) {
        this.id = id;
        this.iconGroupId = iconGroupId;
        this.iconImageUrl = iconImageUrl;
    }

}
