package com.example.springserver.Controller;

import com.example.springserver.Dao.ConsignmentDao;
import com.example.springserver.Dao.ConsignmentOrderDao;
import com.example.springserver.Models.Consignment;
import com.example.springserver.Models.ConsignmentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ConsignmentOrderController
{
    @Autowired
    private ConsignmentOrderDao consignmentOrderDao;

    @GetMapping("/consignment/order/get-all")
    public List<ConsignmentOrder> getAllConsignments()
    {
        return consignmentOrderDao.getAllConsignmentOrder();
    }

    @PostMapping("/consignment/order/save")
    public void save(@RequestBody ConsignmentOrder consignmentOrder) {consignmentOrderDao.save(consignmentOrder);}

    @RequestMapping(value = "/consignment/order/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            consignmentOrderDao.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
