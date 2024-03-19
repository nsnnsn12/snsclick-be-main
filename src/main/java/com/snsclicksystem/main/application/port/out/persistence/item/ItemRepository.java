package com.snsclicksystem.main.application.port.out.persistence.item;

import com.snsclicksystem.main.domain.item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findById(Long id);

    List<Item> findByItemTypeAndGreaterItemPrice(ItemCriteria criteria);
}
