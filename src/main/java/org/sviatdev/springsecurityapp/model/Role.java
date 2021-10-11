package org.sviatdev.springsecurityapp.model;

/*
* Simple JavaBean object that represents role of {@link User}
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
