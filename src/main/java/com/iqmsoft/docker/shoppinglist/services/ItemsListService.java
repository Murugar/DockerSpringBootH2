package com.iqmsoft.docker.shoppinglist.services;

import java.util.List;

import com.iqmsoft.docker.shoppinglist.dto.ItemsListDto;
import com.iqmsoft.docker.shoppinglist.entities.ItemsList;


public interface ItemsListService {
    long addItemsList(ItemsListDto itemsListDto);

    void updateItemsList(ItemsListDto itemsListDto);

    void deleteItemsList(long id);

    ItemsList getItemsListById(long id);

    List<ItemsList> findAllLists();
}
