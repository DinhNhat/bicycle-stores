package com.nhatdinhnguyen.bicycleproject.web.api;

import com.nhatdinhnguyen.bicycleproject.db.entity.Order;
import com.nhatdinhnguyen.bicycleproject.db.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "orders/search-user-defined")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/{firstName}")
    Iterable<Order> findByFirstNameCustomer(@PathVariable(value = "firstName") String firstName) {
        return this.orderRepository.findByCustomer_Person_FirstName(firstName);
    }

    // using PathVariable
//    @RequestMapping(method = RequestMethod.GET, path = "/order-date/{orderDate}")
//    List<Order> findBySpecialDate(@PathVariable(value = "orderDate") String orderDate) {
//        Date oDate = DateUtils.createDateFormatString(orderDate);
//        return this.orderRepository.findByOrderDate(oDate);
//    }

    // using @RequestParam
//    @RequestMapping(method = RequestMethod.GET, path = "/order-date")
//    List<Order> findBySpecialDate(@RequestParam(value = "orderDate") String orderDate) {
//        Date oDate = DateUtils.createDateFormatString(orderDate);
//        return this.orderRepository.findByOrderDate(oDate);
//    }

    // using @RequestBody
    @RequestMapping(method = RequestMethod.GET, path = "/order-date")
    List<Order> findBySpecialDate(@RequestBody String orderDate) {
        Date oDate = DateUtils.createDateFormatString(orderDate);
        return this.orderRepository.findByOrderDate(oDate);
    }

}
