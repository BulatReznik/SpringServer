package com.example.springserver.Dao;

import com.example.springserver.Models.Consignment;
import com.example.springserver.Models.ConsignmentOrder;
import com.example.springserver.Repository.CategoryRepository;
import com.example.springserver.Repository.ConsignmentOrderRepository;
import com.example.springserver.Repository.ConsignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.List;

public class ConsignmentOrderDao
{
    @Autowired
    private ConsignmentOrderRepository repository;

    public void save(ConsignmentOrder consignmentOrder)
    {
        repository.save(consignmentOrder);
    }

    public void delete(int consignmentOrderId)
    {
        repository.deleteById(consignmentOrderId);
    }

    public ConsignmentOrder getConsignmentOrder(int consignmentId) {return repository.findById(consignmentId).get();}

    public List<ConsignmentOrder> getAllConsignmentOrder()
    {
        List<ConsignmentOrder> consignmentOrders = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(consignmentOrders::add);
        return consignmentOrders;
    }
}
