package com.snsclicksystem.main.adapter.out.persistence.real_site;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealSiteJPARepository extends JpaRepository<RealSiteEntity, Long> {
    Optional<RealSiteEntity> findByItemId(Long itemId);
}
