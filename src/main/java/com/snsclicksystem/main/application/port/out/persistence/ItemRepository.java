package com.snsclicksystem.main.application.port.out.persistence;

import com.snsclicksystem.main.domain.item.SnsItem;

public interface ItemRepository {
    SnsItem findById(Long id);
}
