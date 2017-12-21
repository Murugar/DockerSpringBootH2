package com.iqmsoft.docker.shoppinglist.controllers.rest;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.docker.shoppinglist.dto.ItemDto;
import com.iqmsoft.docker.shoppinglist.entities.Item;
import com.iqmsoft.docker.shoppinglist.services.ItemService;

import static com.iqmsoft.docker.shoppinglist.Application.API_BASE_URL;
import static com.iqmsoft.docker.shoppinglist.controllers.ItemController.ITEM_BASE_PATH;

import javax.validation.Valid;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(API_BASE_URL + ITEM_BASE_PATH)
public class ItemRestController {
    private final ItemService itemService;

    @ApiOperation("Get item")
    @GetMapping("/{id}")
    public Item getItem(@PathVariable final long id) {
        return itemService.getItemById(id);
    }

    @ApiOperation("Add item")
    @PostMapping
    public ResponseEntity<ItemDto> saveItem(@Valid @RequestBody ItemDto itemDto) {
        itemService.addItem(itemDto);
        return new ResponseEntity<>(itemDto, HttpStatus.CREATED);
    }

    @ApiOperation("Update item")
    @PutMapping
    public ResponseEntity editItem(@Valid @RequestBody ItemDto itemDto) {
        if (itemService.getItemById(itemDto.getId()) == null) {
            log.error("Item with id '" + itemDto.getId() + "' not found");
            return ResponseEntity.notFound().build();
        }
        itemService.updateItem(itemDto);
        return ResponseEntity.ok(itemDto);
    }

    @ApiOperation("Delete item")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable final long id) {
        if (itemService.getItemById(id) == null) {
            log.error("Item with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
