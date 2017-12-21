package com.iqmsoft.docker.shoppinglist.services;

import com.iqmsoft.docker.shoppinglist.dto.ItemDto;
import com.iqmsoft.docker.shoppinglist.entities.Item;


public interface ItemService {
    void addItem(ItemDto itemDto);

    void updateItem(ItemDto itemDto);

    void deleteItem(long id);

    Item getItemById(long id);

    void toggleBoughtStatus(long id);
}
