package com.gerenciamentodeprocessos.repositories;


import com.gerenciamentodeprocessos.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String > {
}
