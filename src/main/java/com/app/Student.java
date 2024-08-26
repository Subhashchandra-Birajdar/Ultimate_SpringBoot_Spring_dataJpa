package com.app;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid; // shift+alt select multiple operation copy

    @Column(name="fname",length=300)
    private String firstname;

    @Column(name="lname",length=300)
    private String lastname;

    @Column(length=300,unique = true)
    private String email;

    private int age;
}

