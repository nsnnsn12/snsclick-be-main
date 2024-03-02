package com.snsclicksystem.main.adapter.out.persistence.item;

import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJPARepository jpaRepository;
    @Override
    public Optional<SnsItem> findById(Long id) {
        Optional<ItemEntity> item = jpaRepository.findById(id);
        return item.map(this::getSnsItemFromModel);
    }

    private SnsItem getSnsItemFromModel(ItemEntity entity){
        return SnsItem.builder().
                    id(entity.getId()).
                    itemType(entity.getItemType()).
                    itemPrice(entity.getItemPrice()).
                    itemSolidPrice(entity.getItemSolidPrice()).
                    minOrderQuantity(entity.getMinOrderQuantity()).
                    maxOrderQuantity(entity.getMaxOrderQuantity()).
                    isRepeatable(entity.getIsRepeatable()).
                    isCancelable(entity.getIsCancelable()).
                    averageCompletionTime(entity.getAverageCompletionTime()).build();
    }
}
