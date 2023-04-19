package com.nc.college.bazaar.service.impl;

import com.nc.college.bazaar.entity.ConfirmationToken;
import com.nc.college.bazaar.entity.UserEntity;
import com.nc.college.bazaar.exception.UserException;
import com.nc.college.bazaar.repositry.ConfirmationTokenRepository;
import com.nc.college.bazaar.response.UserResponse;
import com.nc.college.bazaar.model.UserModel;
import com.nc.college.bazaar.repositry.UserRepositry;
import com.nc.college.bazaar.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepositry userRepositry;
    @Autowired
    private EmailService emailService;
    private ConfirmationTokenRepository confirmationTokenRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserRepositry userRepositry, ConfirmationTokenRepository confirmationTokenRepository) {
        this.userRepositry = userRepositry;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public UserResponse createUser(UserModel userModel) {

        System.out.println(isUserExist(userModel.getEmail()));
        userModel.setIsVerify(false);

        if (!isUserExist(userModel.getEmail())) {
            UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);
            UserEntity user = userRepositry.save(userEntity);
            sendMainToUser(userEntity);
            return new UserResponse(HttpStatus.CREATED, "User Created!  Verification main send to your mail account");
        } else {
            throw new UserException(HttpStatus.BAD_REQUEST, "User already exist.");
        }
    }

    @Override
    public UserModel getUser(UserModel userModel) {
        UserEntity user = userRepositry.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        return modelMapper.map(user, UserModel.class);
    }


    @Override
    public boolean isUserExist(java.lang.String email) {
        return userRepositry.findUserByEmail(email).size() > 0 ? true : false;
    }


    void sendMainToUser(UserEntity user) {
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

        emailService.sendEmail(mailMessage);
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            UserEntity userEntity = userRepositry.findByEmailIgnoreCase(token.getUserEntity().getEmail());
            userEntity.setIsVerify(true);
            userRepositry.save(userEntity);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }
}
