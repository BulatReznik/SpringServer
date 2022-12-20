package com.example.springserver.Dao;

import com.example.springserver.Models.Category;
import com.example.springserver.Models.Consignment;
import com.example.springserver.Repository.ConsignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsignmentDao
{
    @Autowired
    private ConsignmentRepository repository;

    public void save(Consignment consignment) {repository.save(consignment);}

    public void delete(int consignmentId)
    {
        repository.deleteById(consignmentId);
    }

    public Consignment getConsignment(int consignmentId) {return repository.findById(consignmentId).get();}

    public List<Consignment> getAllConsignments()
    {
        List<Consignment> consignments = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(consignments::add);
        return consignments;
    }


}
