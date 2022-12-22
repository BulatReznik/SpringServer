package com.example.springserver.Controller;
import com.example.springserver.Dao.OrderDao;
import com.example.springserver.Dto.OrderDto;
import com.example.springserver.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            orderDao.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/order/{id}")
    public void getOrder(@PathVariable(value = "id") Integer id){ orderDao.getOrder(id);}


    @PostMapping(value = "/order/{orderId}/consignment/{consignmentId}/{count}/add")
    public ResponseEntity<OrderDto> addConsignmentToOrder(@PathVariable final int orderId,
                                                          @PathVariable final int consignmentId,
                                                          @PathVariable final int count) {
        Order order = orderDao.addConsignmentToOrder(orderId, consignmentId, count);
        return new ResponseEntity<>(OrderDto.from(order), HttpStatus.OK);
    }

}
