package com.snsclicksystem.main.adapter.out.persistence.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemCriteria;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.snsclicksystem.main.adapter.out.persistence.item.QItemEntity.itemEntity;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJPARepository jpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<SnsItem> findById(Long id) {
        Optional<ItemEntity> item = jpaRepository.findById(id);
        return item.map(this::getSnsItemFromModel);
    }

    @Override
    public List<SnsItem> findByItemTypeAndGreaterItemPrice(ItemCriteria criteria) {
        List<ItemEntity> fetch = jpaQueryFactory.selectFrom(itemEntity)
                .where(eqItemType(criteria.getItemType()),
                        graterItemType(criteria.getItemPrice()))
                .fetch();
        return fetch.stream().map(this::getSnsItemFromModel).toList();
    }

    private BooleanExpression eqItemType(String itemType){
        if(!StringUtils.hasText(itemType)) return null;
        return itemEntity.itemType.eq(itemType);
    }

    private BooleanExpression graterItemType(Integer itemPrice){
        if(itemPrice == null) return null;
        return itemEntity.itemPrice.goe(itemPrice);
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
