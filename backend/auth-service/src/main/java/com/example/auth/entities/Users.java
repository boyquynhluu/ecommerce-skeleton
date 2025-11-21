package com.example.auth.entities;

import java.sql.Timestamp;
import java.util.Set;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tbl_users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", length = 50, unique = true)
    String username;

    @Column(name = "email", length = 100, unique = true)
    String email;

    @Column(name = "password", length = 255)
    String password;

    @Column(name = "active")
    boolean active;

    @Column(name = "create_at")
    Timestamp createAt;

    @Column(name = "update_at")
    Timestamp updateAt;

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Roles> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "refresh_token_id", referencedColumnName = "id")
    RefreshToken refreshToken;
}
