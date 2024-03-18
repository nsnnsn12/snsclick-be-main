package com.snsclicksystem.main.domain.item;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SnsItem {
    private Long id;
    private Long serviceId;
    private String name;
    private String content;
    private Integer price;
}
