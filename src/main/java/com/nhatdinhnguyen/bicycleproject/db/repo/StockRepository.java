package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.entity.Stock;
import com.nhatdinhnguyen.bicycleproject.db.entity.StockPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, StockPk> {
    List<Stock> findByProduct_Id(@Param("productId")Integer id);
}
