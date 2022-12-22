package com.example.springserver.Dto;
import com.example.springserver.Models.Consignment;
import com.example.springserver.Models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDto
{
    private int id;
    private String name;
    private String date;

    private float total;
    private List<ConsignmentOrderDto> consignments = new ArrayList<>();

    public List<ConsignmentOrderDto> getConsignments() {return consignments;}

    public void setConsignments(List<ConsignmentOrderDto> consignments) {this.consignments = consignments;}
    public void addConsignment(ConsignmentOrderDto orderDto) {consignments.add(orderDto);}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public float getTotal() {return total;}
    public void setTotal(float total) {this.total = total;}

    public static OrderDto from(Order order)
    {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setDate(order.getDate());
        orderDto.setTotal(order.getTotal());
        orderDto.setConsignments(order.getConsignments().stream().map(ConsignmentOrderDto::from).collect(Collectors.toList()));
        return orderDto;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}