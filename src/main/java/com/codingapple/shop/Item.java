package com.codingapple.shop;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String title;
    public Integer price;

}

