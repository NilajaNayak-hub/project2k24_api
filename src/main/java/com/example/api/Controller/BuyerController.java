package com.example.api.Controller;

import com.example.api.Entity.BuyerMaster;
import com.example.api.Entity.SellerMaster;
import com.example.api.Repository.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@CrossOrigin("*")
public class BuyerController {

    @Autowired
    private BuyerRepo buyerrepo;

    @PostMapping("/BuyerRegister")
    public ResponseEntity<?> BuyerRegister(@RequestBody BuyerMaster obj) {

        Random rnd = new Random();
        int BId = rnd.nextInt(100000, 999999);
        String password = String.valueOf(rnd.nextInt(1000, 9999));
        obj.setBid(BId);
        obj.setPassword(password);
        buyerrepo.save(obj);
        return new ResponseEntity<>("Buyer Register Successfully & Login Id:"+BId+",Password:"+password, HttpStatus.OK);

    }
}
