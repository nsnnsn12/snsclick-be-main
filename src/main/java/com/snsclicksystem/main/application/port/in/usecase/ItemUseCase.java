package com.snsclicksystem.main.application.port.in.usecase;

import com.snsclicksystem.main.domain.item.SnsItem;

public interface ItemUseCase {
    SnsItem getItem(Long id);
}
