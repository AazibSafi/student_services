package com.student.studentservices.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import java.util.Set;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(min = 10, max = 10)
    private String rut;

    private String name;
    private String lastName;

    @Min(19)
    private Integer age;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses;

}
