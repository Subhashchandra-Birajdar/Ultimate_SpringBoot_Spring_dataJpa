package com.app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    // this tells jackson that the parent is in charge of serializing and child and prevents the child fromm trying to serialize the parent
    // now we need to the json manager on parent level
    private List<Student> students;

}

