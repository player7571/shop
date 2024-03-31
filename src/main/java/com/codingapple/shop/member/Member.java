package com.codingapple.shop.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Member {
    @Id
    @Getter @Setter
    private String username;
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String displayName;
}
