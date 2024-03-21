package com.snsclicksystem.main.application.service.item;

import com.snsclicksystem.main.application.port.in.item.ItemNotFoundException;
import com.snsclicksystem.main.application.port.in.item.ItemUseCase;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.item.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService implements ItemUseCase {
    private final ItemRepository itemRepository;

    @Override
    public Item getItem(Long id) throws ItemNotFoundException {
        return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }
}
