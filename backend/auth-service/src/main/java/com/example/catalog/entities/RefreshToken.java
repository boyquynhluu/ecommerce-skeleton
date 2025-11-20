package com.example.auth.entities;

import java.sql.Timestamp;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tbl_refresh_token")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "token", columnDefinition = "TEXT")
    String token;

    @Column(name = "expires_at")
    Timestamp expiresAt;

    @Column(name = "create_at")
    Timestamp createAt;

    @Column(name = "revoked")
    boolean revoked;

    @OneToOne(mappedBy = "refreshToken")
    Users user;
}
