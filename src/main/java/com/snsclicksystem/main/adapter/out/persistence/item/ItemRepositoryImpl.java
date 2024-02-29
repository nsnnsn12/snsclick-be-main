package com.snsclicksystem.main.adapter.out.persistence.item;

import com.snsclicksystem.main.application.port.out.persistence.ItemRepository;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJPARepository jpaRepository;
    private final ObjectMapper objectMapper;
    @Override
    public SnsItem findById(Long id) {
        ItemEntity itemEntity = jpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id 입니다."));
        return objectMapper.convert(itemEntity, SnsItem.class);
    }
}
