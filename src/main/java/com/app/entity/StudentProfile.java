package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_studentProfile")
public class StudentProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bio;

    @OneToOne
    @JoinColumn(
            name="student_id"
    )
    private Student student1;
    //here student ref match with student class mappedBy otherwise you will get exception/error
}

