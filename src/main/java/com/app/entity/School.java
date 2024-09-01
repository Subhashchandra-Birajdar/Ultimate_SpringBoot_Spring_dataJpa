package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_school")
public class School  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolid;

    @Column(name="s_name")
    private String schoolname;

    @OneToMany(
            mappedBy = "school"
    )
    private List<Student> students;

}

