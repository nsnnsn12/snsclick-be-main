package com.snsclicksystem.main.adapter.out.persistence.real_site;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RealSiteRepositoryImpl implements RealSiteRepository{
	private final RealSiteJPARepository jpaRepository;
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public RealSiteEntity findByItemId(Long itemId) {
		return jpaRepository.findByItemId(itemId).orElseThrow(()->new IllegalArgumentException("해당 아이템이 존재하지 않습니다."));
	}
}
