package com.example.springserver.Repository;

import com.example.springserver.Models.Consignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsignmentRepository extends CrudRepository<Consignment, Integer> {

}
