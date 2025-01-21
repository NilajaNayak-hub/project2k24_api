package com.example.api.Controller;

import com.example.api.Entity.BuyerMaster;
import com.example.api.Entity.PostMessage;
import com.example.api.Entity.PropertyMaster;
import com.example.api.Repository.BuyerRepo;
import com.example.api.Repository.PostMessageRepo;
import com.example.api.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class PostMessageController {

    @Autowired
    private SellerRepo sellerrepo;

    @Autowired
    private BuyerRepo buyerrepo;

    @Autowired
    private PostMessageRepo postmessagerepo;

    @PostMapping("/BuyerPostMessage/{id}/{bid}")
    public ResponseEntity<?> BuyerPostMessage(@PathVariable Integer id,@PathVariable Integer bid, @RequestBody PostMessage obj) {

        var sellerlst = sellerrepo.findById(id).orElseThrow(() -> new RuntimeException("Seller id Not Found"));
        obj.setSellermasterlst(sellerlst);
        var buyerlst = buyerrepo.findById(bid).orElseThrow(() -> new RuntimeException("Buyer id Not Found"));
        obj.setBuyermaster(buyerlst);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        obj.setPostdate(dateFormat.format(date));
        postmessagerepo.save(obj);
        return new ResponseEntity<>("Post Message Successfully", HttpStatus.OK);

    }
    @GetMapping("/GetPostMessage")
    public ResponseEntity<?> GetPostMessage() {
        var msglst = postmessagerepo.findAll();
        return new ResponseEntity<>(msglst, HttpStatus.OK);
    }
}
