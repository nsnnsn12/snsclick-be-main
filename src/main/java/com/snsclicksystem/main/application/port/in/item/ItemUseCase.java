package com.snsclicksystem.main.application.port.in.item;

import com.snsclicksystem.main.domain.item.Item;

public interface ItemUseCase {
    Item getItem(Long id) throws ItemNotFoundException;
}
