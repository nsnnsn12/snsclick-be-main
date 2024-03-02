package com.snsclicksystem.main.application.port.out.persistence.item;

import com.snsclicksystem.main.domain.item.SnsItem;

import java.util.Optional;

public interface ItemRepository {
    Optional<SnsItem> findById(Long id);
}
