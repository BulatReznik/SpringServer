package com.example.springserver.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "consignments")
public class Consignment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    private int price;
    private String description;
    private String name;

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString()
    {
        return "Consignment{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
