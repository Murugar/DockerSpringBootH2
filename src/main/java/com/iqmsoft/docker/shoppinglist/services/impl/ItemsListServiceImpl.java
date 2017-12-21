package com.iqmsoft.docker.shoppinglist.services.impl;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.docker.shoppinglist.dto.ItemsListDto;
import com.iqmsoft.docker.shoppinglist.entities.ItemsList;
import com.iqmsoft.docker.shoppinglist.repositories.ItemsListRepository;
import com.iqmsoft.docker.shoppinglist.services.ItemsListService;

import java.util.List;


@AllArgsConstructor
@Service
@Transactional
public class ItemsListServiceImpl implements ItemsListService {
    private final ItemsListRepository itemsListRepository;

    @Override
    public long addItemsList(ItemsListDto itemsListDto) {
        return itemsListRepository.saveAndFlush(itemsListDto.toItemsList()).getId();
    }

    @Override
    public void updateItemsList(ItemsListDto itemsListDto) {
        val itemsList = itemsListRepository.findOne(itemsListDto.getId());
        itemsListDto.toItemsList(itemsList);
        itemsListRepository.saveAndFlush(itemsList);
    }

    @Override
    public void deleteItemsList(long id) {
        itemsListRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ItemsList getItemsListById(long id) {
        return itemsListRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemsList> findAllLists() {
        return itemsListRepository.findAll();
    }
}
