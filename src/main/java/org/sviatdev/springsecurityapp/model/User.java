package org.sviatdev.springsecurityapp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
                           inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

}
