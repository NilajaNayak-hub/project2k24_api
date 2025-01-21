package com.example.api.Controller;

import com.example.api.DTO.LoginDTO;
import com.example.api.Repository.AdminRepo;
import com.example.api.Repository.BuyerRepo;
import com.example.api.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private SellerRepo sellerrepo;

    @Autowired
    private BuyerRepo buyerrepo;

    @Autowired
    private AdminRepo adminrepo;

    @PostMapping("/LoginVerify")
    public ResponseEntity<?> LoginVerify(@RequestBody LoginDTO obj) {
        if (obj.getUsertype().equals("Admin")) {
            var user = adminrepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if (obj.getUsertype().equals("Seller")) {
            var user = sellerrepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else if (obj.getUsertype().equals("Buyer")) {
            var user = buyerrepo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Success", HttpStatus.OK);

            } else {
                throw new RuntimeException("Invalid Password");
            }
        }
        else {

            throw new RuntimeException("Invalid Password");

        }
    }
}
