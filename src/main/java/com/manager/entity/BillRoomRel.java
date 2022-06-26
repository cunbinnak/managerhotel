package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@MappedSuperclass
public class BillRoomRel  extends EntityBase {

    @Column(name = "bill_id")
    private String billId;
    @Column(name = "room_id")
    private String roomId;
    @Column(name = "price_room")
    private Double priceRoom;
    @Column(name = "in_date")
    private Timestamp inDate;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
