package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@MappedSuperclass
public class Bill  extends EntityBase {

    @Column(name = "invoice_date")
    private Timestamp invoiceDate;
    @Column(name = "checkin_date")
    private Timestamp checkinDate;
    @Column(name = "checkout_date")
    private Timestamp checkoutDate;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "people_number")
    private Integer peopleNumber;
    @Column(name = "status")
    private String status;

    @OneToMany
    @JoinColumn(name = "id")
    private List<BillRoomRel> billRoomRel;

    @OneToMany
    @JoinColumn(name = "id")
    private List<BillServiceRels> billServiceRels;
}
