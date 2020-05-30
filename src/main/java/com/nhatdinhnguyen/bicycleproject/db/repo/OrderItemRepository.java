package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.entity.OrderItem;
import com.nhatdinhnguyen.bicycleproject.db.entity.OrderItemPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, OrderItemPk> {
    List<OrderItem> findByProduct_Id(@Param("productId")int productId);
    List<OrderItem> findByProductIdIn(@Param("listId")List<Integer> ids);

    List<OrderItem> findByPk_ItemId(@Param("itemId")int itemId);
}
