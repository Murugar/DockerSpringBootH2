package com.iqmsoft.docker.shoppinglist.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.docker.shoppinglist.dto.ItemDto;
import com.iqmsoft.docker.shoppinglist.entities.Item;
import com.iqmsoft.docker.shoppinglist.repositories.ItemRepository;
import com.iqmsoft.docker.shoppinglist.repositories.ItemsListRepository;
import com.iqmsoft.docker.shoppinglist.services.ItemService;


@AllArgsConstructor
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemsListRepository itemsListRepository;

    @Override
    public void addItem(ItemDto itemDto) {
        val item = itemDto.toItem();
        item.setItemsList(itemsListRepository.findOne(itemDto.getListId()));
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        val item = itemRepository.findOne(itemDto.getId());
        itemDto.toItem(item);
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Item getItemById(long itemId) {
        return itemRepository.findOne(itemId);
    }

    @Override
    public void toggleBoughtStatus(long itemId) {
        val item = itemRepository.findOne(itemId);
        item.setBought(!item.isBought());
        itemRepository.saveAndFlush(item);
    }
}
