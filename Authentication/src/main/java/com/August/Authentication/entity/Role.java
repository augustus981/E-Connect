package com.August.Authentication.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    @Size(max=255)
    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<UserPrincipal> userEntity;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserPrincipal> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(Set<UserPrincipal> userEntity) {
        this.userEntity = userEntity;
    }
}
