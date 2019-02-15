package com.app.phonebook.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    @Column(name = "enabled")
    private boolean enabled;
    @ElementCollection
    @CollectionTable(name="roles", joinColumns=@JoinColumn(name="userId"))
    @Column(name="role")
    private List<String> roles;

    public User() {
        super();
        this.enabled = false;
    }
}
