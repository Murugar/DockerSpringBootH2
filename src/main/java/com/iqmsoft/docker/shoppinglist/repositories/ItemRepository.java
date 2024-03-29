package com.iqmsoft.docker.shoppinglist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.docker.shoppinglist.entities.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
