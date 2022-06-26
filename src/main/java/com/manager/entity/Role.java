package com.manager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "role")
@MappedSuperclass
public class Role extends EntityBase{

    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "role_name")
    private String roleName;

    @OneToMany
    @JoinColumn(name = "id")
    private List<UserRoleRels> userRoleRelsList;

}
