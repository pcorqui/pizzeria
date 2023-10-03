package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "userpizza")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column
    private Long Id;

    @Column
    private String username;

    @Column(nullable = false,length = 200)
    private String password;

    @Column(length = 50)
    private String email;

//    @Column(nullable = false)
//    private Boolean locked;
//
//    @Column(nullable = false
//    )
//    private Boolean disabled;
}
