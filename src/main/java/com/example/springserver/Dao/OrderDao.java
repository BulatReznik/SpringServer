package com.example.springserver.Dao;

import com.example.springserver.Models.Consignment;
import com.example.springserver.Models.ConsignmentOrder;
import com.example.springserver.Models.Order;
import com.example.springserver.Repository.ConsignmentRepository;
import com.example.springserver.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDao
{
    @Autowired
    private OrderRepository orderRepository;
    private ConsignmentRepository consignmentRepository;
    private ConsignmentDao consignmentService;

    public void save(Order order)
    {
        orderRepository.save(order);
    }

    public void delete(int orderId)
    {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getAllOrders()
    {
        List<Order> orders = new ArrayList<>();
        Streamable.of(orderRepository.findAll())
                .forEach(orders::add);
        return orders;
    }
    public Order getOrder(int orderId) {return orderRepository.findById(orderId).get();}

    @Transactional
    public Order addConsignmentToOrder(int orderId, int consignmentId, int count)
    {
        Order order = getOrder(orderId);
        Consignment consignment = consignmentService.getConsignment(consignmentId);
        ConsignmentOrder detail = new ConsignmentOrder();
        detail.setOrder(order);
        detail.setConsignment(consignment);
        detail.setCount(count);
        detail.setSubtotal(consignment.getPrice() * count);
        order.addConsignmentOrder(detail);
        return order;
    }
}
