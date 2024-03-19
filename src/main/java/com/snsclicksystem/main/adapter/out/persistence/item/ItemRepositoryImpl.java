package com.snsclicksystem.main.adapter.out.persistence.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemCriteria;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.item.Item;
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
    public Optional<Item> findById(Long id) {
        Optional<ItemEntity> item = jpaRepository.findById(id);
        return item.map(this::getSnsItemFromModel);
    }

    @Override
    public List<Item> findByItemTypeAndGreaterItemPrice(ItemCriteria criteria) {
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

    private Item getSnsItemFromModel(ItemEntity entity){
        //TODO need to implement
        return null;
    }
}
