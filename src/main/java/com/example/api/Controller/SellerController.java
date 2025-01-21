package com.example.api.Controller;

import com.example.api.Entity.SellerMaster;
import com.example.api.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")
public class SellerController {

    @Autowired
    private SellerRepo sellerrepo;


    @PostMapping("/SellerRegister")
    public ResponseEntity<?> SellerRegister(@RequestBody SellerMaster obj) {

        Random rnd = new Random();
        int SId = rnd.nextInt(100000, 999999);
        String password = String.valueOf(rnd.nextInt(1000, 9999));
        obj.setSid(SId);
        obj.setPassword(password);
        sellerrepo.save(obj);
        return new ResponseEntity<>("Seller Register Successfully & Login Id:"+SId+",Password:"+password, HttpStatus.OK);

    }
}
