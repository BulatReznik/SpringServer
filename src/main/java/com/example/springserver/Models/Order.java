package com.example.springserver.Models;

import com.example.springserver.Dto.OrderDto;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String date;
    private float total;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<ConsignmentOrder> consignments = new ArrayList<>();

    public Order(){}

    public static Order from(OrderDto orderDto)
    {
        Order order = new Order();
        order.setDate(orderDto.getDate());
        order.setTotal(orderDto.getTotal());
        order.setConsignments(orderDto.getConsignments().stream().map(ConsignmentOrder::from).collect(Collectors.toList()));
        return order;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public float getTotal() {return total;}
    public void setTotal(float total) {this.total = total;}

    public void addConsignmentOrder(ConsignmentOrder consignmentOrder) {
        consignments.add(consignmentOrder);
    }

    public List<ConsignmentOrder> getConsignments() {
        return consignments;
    }

    public void setConsignments(List<ConsignmentOrder> consignments) {this.consignments = consignments;}

    @Override
    public String toString()
    {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /* @ManyToMany
    @JoinTable(name = "consignments_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "consignment_id"))
    private List<ConsignmentOrder> consignments = new ArrayList<>();*/
}