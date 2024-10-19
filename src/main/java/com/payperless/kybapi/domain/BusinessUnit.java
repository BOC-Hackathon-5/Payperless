package com.payperless.kybapi.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "business_unit")
public class BusinessUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jinius_entity_id")
    private JiniusEntity jiniusEntity;
    private String jiniusId;
    private String name;
    private String address;
    private String city;
    private String postcode;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "businessUnit")
    private List<Identifier> identifiers;

}