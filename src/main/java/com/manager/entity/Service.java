package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "service")
@MappedSuperclass
public class Service  extends EntityBase {

    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "unit")
    private String unit;

    @OneToMany
    @JoinColumn(name = "id")
    private List<BillServiceRels> billServiceRels;


}
