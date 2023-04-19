package com.nc.college.bazaar.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "confirmationToken")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private long tokenid;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private UserEntity userEntity;


    public ConfirmationToken(UserEntity userEntity) {
        this.userEntity = userEntity;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

    public ConfirmationToken() {
    }

    public long getTokenid() {
        return tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
