package com.nc.college.bazaar.entity;

import com.nc.college.bazaar.constaint.Users;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allUser", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;
    String name;
    String password;
    String email;

    String type;
    String  otp;
    Boolean isVerify=false;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setVerify(Boolean verify) {
        isVerify = verify;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getOtp() {
        return otp;
    }

    public Boolean getVerify() {
        return isVerify;
    }
}
