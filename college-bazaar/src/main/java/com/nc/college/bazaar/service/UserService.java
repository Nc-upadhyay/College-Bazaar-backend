package com.nc.college.bazaar.service;

import com.nc.college.bazaar.model.UserModel;
import com.nc.college.bazaar.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
UserResponse createUser(UserModel userModel);
UserModel getUser(UserModel userModel);

boolean isUserExist(java.lang.String email);

ResponseEntity<?> confirmEmail(String token);

}
