package springboot.controller;


import springboot.entity.Order;
import springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order Order) {
        return service.saveOrder(Order);
    }

    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> Orders) {
        return service.saveOrders(Orders);
    }

    @GetMapping("/Orders")
    public List<Order> findAllOrders() {
        return service.getOrders();
    }

    @GetMapping("/OrderById/{id}")
    public Order findOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @GetMapping("/Order/{name}")
    public Order findOrderByName(@PathVariable String name) {
        return service.getOrderByName(name);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order Order) {
        return service.updateOrder(Order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }
}
