package com.snsclicksystem.main.domain.item;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Item {
    private Long id;
    private String name;
    private String content;
    private Long price;
}
