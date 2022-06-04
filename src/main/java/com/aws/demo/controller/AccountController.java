package com.aws.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.aws.demo.model.*;

@RequestMapping("/api/account")
@RestController

public class AccountController {
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Account acc) throws SQLException, ClassNotFoundException{
        if (Account.login(acc)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/change_password")
    public void Change_Password(@RequestBody Account acc) throws SQLException, ClassNotFoundException{
        Account.change_password(acc);
    }
}