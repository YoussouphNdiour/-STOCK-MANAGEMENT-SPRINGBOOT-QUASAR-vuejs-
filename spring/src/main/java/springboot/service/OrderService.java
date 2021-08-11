package springboot.service;


import springboot.entity.Order;
import springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order Order) {
        return repository.save(Order);
    }

    public List<Order> saveOrders(List<Order> Orders) {
        return repository.saveAll(Orders);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Order getOrderByName(String name) {
        return repository.findByName(name);
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);
        return "Order removed !! " + id;
    }

    public Order updateOrder(Order Order) {
        Order existingOrder = repository.findById(Order.getId()).orElse(null);
        existingOrder.setIdProvider(Order.getIdProvider());
        existingOrder.setIdProduct(Order.getIdProduct());
        existingOrder.setprice(Order.getprice());
        existingOrder.setquantity(Order.getquantity());
        return repository.save(existingOrder);
    }


}