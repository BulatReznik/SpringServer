package com.example.springserver.Controller;
import com.example.springserver.Dao.ConsignmentDao;
import com.example.springserver.Models.Category;
import com.example.springserver.Models.Consignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/consignment/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            consignmentDao.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/consignment/{id}")
    public void getConsignment(@PathVariable(value = "id") Integer id){ consignmentDao.getConsignment(id);}



}
