package com.cap.apps.customerwithitem.customerwithitem.itemms.repository;




import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

}


