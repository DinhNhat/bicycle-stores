package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    List<Order> findByCustomerId(@Param("cusid")Integer cusId);
    List<Order> findByStore_Id(@Param("storeId")Integer storeId);
    List<Order> findByCustomerPersonLastNameLike(@Param("lastName")String lastName);
    List<Order> findByCustomer_Person_FirstName(@Param("firstName")String firstName);
    List<Order> findByStatusIn(@Param("statuses") List<Integer> statuses);
    Page<Order> findByStatus(@Param("status")int status, Pageable pageable);
//    List<Order> findByOrderDate(@RequestParam("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate);
    List<Order> findByOrderDate(Date orderDate);
    Page<Order> findByOrderDateGreaterThan(@Param("orderDateGreater")
                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                   Date orderDateGreater, Pageable pageable);

    List<Order> findByStoreNameContains(@Param("name")String name);
}
