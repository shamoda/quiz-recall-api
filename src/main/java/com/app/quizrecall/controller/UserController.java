package com.app.quizrecall.controller;

import com.app.quizrecall.model.User;
import com.app.quizrecall.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestParam(name = "id", required = false) Integer id,
                                        @RequestParam(name = "name") String name,
                                        @RequestParam(name = "mobileNo") String mobileNo,
                                        @RequestParam(name = "fee", required = false) int fee,
                                        @RequestParam(name = "status", required = false) String status) {
        try {
            User user = userService.getUserByMobileNo(mobileNo);

            if (user == null) {
                user = new User();
                user.setName(name);
                user.setMobileNo(mobileNo);
                user.setFee(fee);
                user.setStatus(status);

                return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("User already exists for mobile no: " + mobileNo, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        try {
            return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mobile/{mobileNo}")
    public ResponseEntity<?> getUserByMobileNo(@PathVariable String mobileNo) {
        try {
            return new ResponseEntity<>(userService.getUserByMobileNo(mobileNo), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
