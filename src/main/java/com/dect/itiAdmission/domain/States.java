package com.dect.itiAdmission.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "states")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class States implements Serializable {
    @Id
    private Long id;

    private String name;

    @OneToMany()
    private Set<Districts> districts;
}