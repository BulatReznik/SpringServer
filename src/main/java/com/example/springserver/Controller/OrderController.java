package com.example.springserver.Controller;
import com.example.springserver.Dao.OrderDao;
import com.example.springserver.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController
{
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/order/get-all")
    public List<Order> getAllOrders()
    {
        return orderDao.getAllOrders();
    }

    @PostMapping("/order/save")
    public void save(@RequestBody Order order)
    {
        orderDao.save(order);
    }

    @DeleteMapping("/order/delete")
    public void delete(@RequestParam(value = "id") Integer id) {orderDao.delete(id);}

}
