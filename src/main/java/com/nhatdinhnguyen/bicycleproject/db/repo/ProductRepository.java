package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByBrand_Id(@Param("id") Integer id);
    Page<Product> findByCategory_Id(@Param("id") Integer id, Pageable pageable);
    List<Product> findByCategory_IdAndCategory_Name(@Param("id") int id, @Param("name") String name);
    List<Product> findByBrand_IdOrCategory_Id(@Param("brandId")int id, @Param("categoryId") int cateId);
}
