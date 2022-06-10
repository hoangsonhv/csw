package com.example.csw.entity;

import com.example.csw.annocation.Column;
import com.example.csw.annocation.Table;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", type = "VARCHAR(250)")
    private String name;
    @Column(name = "salary", type = "DOUBLE")
    private Double salary;
}
