package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_role_rels")
@MappedSuperclass
public class UserRoleRels extends EntityBase{

    @Column(name = "role_id")
    private String roleId;
    @Column(name = "user_id")
    private String userId;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
