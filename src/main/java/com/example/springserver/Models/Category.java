package com.example.springserver.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Consignment> consignments;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public void addConsignment(Consignment consignment)
    {
        consignments.add(consignment);
        if(consignment.getCategory()!= this){
            consignment.setCategory(this);
        }
    }
    public List<Consignment> getConsignments(){return this.consignments;}
    public void setConsignments(List<Consignment> consignments) {this.consignments = consignments; }


    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}