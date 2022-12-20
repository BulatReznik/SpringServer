package com.example.springserver.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}