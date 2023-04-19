package com.nc.college.bazaar.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserModel {
    Long id;
    String name;
    String password;
    String email;
    String type;
    String otp;
    Boolean isVerify;

}
