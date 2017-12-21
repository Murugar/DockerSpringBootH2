package com.iqmsoft.docker.shoppinglist.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import com.iqmsoft.docker.shoppinglist.entities.ItemsList;

import java.io.Serializable;

@Getter
@Setter
public class ItemsListDto implements Serializable {
    private static final long serialVersionUID = 1;

    private long id;
    @NotEmpty
    private String name;

    public ItemsListDto() {
    }

    public ItemsListDto(String name) {
        this.name = name;
    }

    public ItemsList toItemsList() {
        return toItemsList(new ItemsList());
    }

    public ItemsList toItemsList(ItemsList itemsList) {
        itemsList.setName(this.name);
        return itemsList;
    }
}
