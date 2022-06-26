package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@MappedSuperclass
public class BillServiceRels  extends EntityBase {

    @Column(name = "bill_id")
    private String billId;
    @Column(name = "service_id")
    private String serviceId;
    @Column(name = "price_service")
    private Double priceService;
    @Column(name = "unit")
    private String unit;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
