package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_customer_rels")
@MappedSuperclass
public class UserCustomerRel extends EntityBase{

    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
