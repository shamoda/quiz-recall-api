package com.app.quizrecall.service;

import com.app.quizrecall.model.User;
import com.app.quizrecall.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        try {
            log.info("Creating user with mobile no: " + user.getMobileNo());
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Error occurred while creating user with mobile no: " + user.getMobileNo());
            log.error(e);
            return null;
        }
    }

    public User getUserById(int userId) {
        try {
            return userRepository.findById(userId).get();
        } catch (Exception e) {
            log.error("Error occurred while getting uset with ID: " + userId);
            log.error(e);
            return null;
        }
    }

    public User getUserByMobileNo(String mobileNo) {
        try {
            return userRepository.findByMobileNo(mobileNo);
        } catch (Exception e) {
            log.error("Error occurred while retrieving user by mobile no: " + mobileNo);
            log.error(e);
            return null;
        }
    }
}
