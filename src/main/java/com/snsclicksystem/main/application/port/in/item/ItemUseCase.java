package com.snsclicksystem.main.application.port.in.item;

import com.snsclicksystem.main.domain.item.SnsItem;

public interface ItemUseCase {
    SnsItem getItem(Long id) throws ItemNotFoundException;
}
