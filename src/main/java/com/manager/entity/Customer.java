package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "customer")
@MappedSuperclass
public class Customer  extends EntityBase {

    @Column(name = "name")
    private String name;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserCustomerRel userCustomerRel;
}
