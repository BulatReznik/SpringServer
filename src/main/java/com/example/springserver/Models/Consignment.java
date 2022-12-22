package com.example.springserver.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consignments")
public class Consignment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Category category;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "consignment")
    private List<ConsignmentOrder> consignmentOrders = new ArrayList<>();
    private int price;
    private String description;
    private String name;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public List<ConsignmentOrder> getConsignmentOrders() {return consignmentOrders;}
    public void setConsignmentOrders(List<ConsignmentOrder> consignmentOrders) {this.consignmentOrders = consignmentOrders;}
    public void addConsignmentOrders(ConsignmentOrder consignmentOrder){this.consignmentOrders.add(consignmentOrder);}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category)
    {
        if(category!=null)
        {
            this.category = category;
            if(!category.getConsignments().contains(this)){
                category.getConsignments().add(this);
            }
        }
    }

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


    /*
    @ManyToMany(mappedBy = "consignments", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void deleteOrder(Order order){
        if (orders.contains(order)) {
            orders.remove(order);
        }
    }
*/
}