package com.snsclicksystem.main.adapter.out.persistence.item;

import com.snsclicksystem.main.application.port.out.persistence.ItemRepository;
import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJPARepository jpaRepository;
    @Override
    public SnsItem findById(Long id) {
        ItemEntity itemEntity = jpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id 입니다."));
        return getSnsItemFromModel(itemEntity);
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
