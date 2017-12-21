package com.iqmsoft.docker.shoppinglist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.docker.shoppinglist.entities.ItemsList;


@Repository
public interface ItemsListRepository extends JpaRepository<ItemsList, Long> {
}
