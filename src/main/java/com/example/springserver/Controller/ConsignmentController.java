package com.example.springserver.Controller;
import com.example.springserver.Dao.ConsignmentDao;
import com.example.springserver.Models.Consignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsignmentController
{
    @Autowired
    private ConsignmentDao consignmentDao;

    @GetMapping("/consignment/get-all")
    public List<Consignment> getAllConsignments()
    {
        return consignmentDao.getAllConsignments();
    }

    @PostMapping("/consignment/save")
    public void save(@RequestBody Consignment consignment)
    {
        consignmentDao.save(consignment);
    }

    @DeleteMapping("/consignment/delete")
    public void delete(@RequestParam(value = "id") Integer id) { consignmentDao.delete(id);}

}
