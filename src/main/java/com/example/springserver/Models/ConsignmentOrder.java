package com.example.springserver.Models;

import com.example.springserver.Dto.ConsignmentOrderDto;
import jakarta.persistence.*;

@Entity
@Table(name = "consignment_order")
public class ConsignmentOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "consignment_id")
    private Consignment consignment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    private int count;
    private float subtotal;

    public ConsignmentOrder(){}

    public static ConsignmentOrder from(ConsignmentOrderDto consignmentOrderDto) {
        ConsignmentOrder consignmentOrder = new ConsignmentOrder();
        consignmentOrder.setCount(consignmentOrderDto.getCount());
        consignmentOrder.setSubtotal(consignmentOrderDto.getSubtotal());
        return consignmentOrder;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Consignment getConsignment() {return consignment;}

    public void setConsignment(Consignment consignment) {this.consignment = consignment;}
    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
