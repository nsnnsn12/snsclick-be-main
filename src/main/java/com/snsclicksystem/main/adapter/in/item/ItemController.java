package com.snsclicksystem.main.adapter.in.item;


import com.snsclicksystem.main.adapter.in.item.dto.ResponseItem;
import com.snsclicksystem.main.application.port.in.usecase.ItemUseCase;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemUseCase itemUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseItem> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(objectMapper.convert(itemUseCase.getItem(id), ResponseItem.class), HttpStatus.OK);
    }
}
