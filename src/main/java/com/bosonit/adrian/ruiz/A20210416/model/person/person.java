package com.bosonit.adrian.ruiz.A20210416.model.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class person {

    @Id
    private String name;
    private String town;
    private Integer age;
}
