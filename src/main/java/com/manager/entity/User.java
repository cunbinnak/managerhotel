package com.manager.entity;

//import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user")
@MappedSuperclass
public class User extends EntityBase {

//    @NotNull
    @Column(name = "username")
    private String username;

//    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserCustomerRel userCustomerRel;

    @ManyToOne
    @JoinColumn(name = "id")
    private UserRoleRels userRoleRelsList;
}
