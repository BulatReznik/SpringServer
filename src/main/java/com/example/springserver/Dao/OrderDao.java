package com.example.springserver.Dao;

import com.example.springserver.Models.Consignment;
import com.example.springserver.Models.Order;
import com.example.springserver.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDao
{
    @Autowired
    private OrderRepository repository;

    public void save(Order order)
    {
        repository.save(order);
    }

    public void delete(int orderId)
    {
        repository.deleteById(orderId);
    }

    public List<Order> getAllOrders()
    {
        List<Order> orders = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(orders::add);
        return orders;
    }
    public Order getOrder(int orderId) {return repository.findById(orderId).get();}
}
