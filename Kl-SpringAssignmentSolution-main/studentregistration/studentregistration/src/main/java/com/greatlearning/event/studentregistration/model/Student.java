package com.greatlearning.event.studentregistration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class Student {
    @Id
    Long id;
    String firstname;
    String lastname;
    String course;
    String country;

}
