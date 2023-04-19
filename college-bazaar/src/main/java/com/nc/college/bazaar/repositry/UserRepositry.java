package com.nc.college.bazaar.repositry;

import com.nc.college.bazaar.entity.UserEntity;
import com.nc.college.bazaar.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepositry extends JpaRepository<UserEntity, Long> {
    @Query("select p from UserEntity p where p.email=:email1")
    public List<UserEntity> findUserByEmail(String email1);

    UserEntity findByEmailIgnoreCase(String emailId);

    UserEntity findByEmailAndPassword(String email, String password);
}
