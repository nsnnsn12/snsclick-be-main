package com.snsclicksystem.main.adapter.out.persistence.real_site;



public interface RealSiteRepository {
    RealSiteEntity findByItemId(Long itemId);
}
