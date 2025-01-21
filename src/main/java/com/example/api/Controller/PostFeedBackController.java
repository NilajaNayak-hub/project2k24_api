package com.example.api.Controller;

import com.example.api.Entity.PostFeedBack;
import com.example.api.Repository.BuyerRepo;
import com.example.api.Repository.PostFeedBackRepo;
import com.example.api.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class PostFeedBackController {
    @Autowired
    private SellerRepo sellerrepo;

    @Autowired
    private BuyerRepo buyerrepo;

    @Autowired
    private PostFeedBackRepo postfeedbackrepo;

    @PostMapping("/BuyerPostFeedBack/{id}/{bid}")
    public ResponseEntity<?> BuyerPostFeedBack(@PathVariable Integer id, @PathVariable Integer bid, @RequestBody PostFeedBack obj) {

        var sellerlst = sellerrepo.findById(id).orElseThrow(() -> new RuntimeException("Seller id Not Found"));
        obj.setSellerlst(sellerlst);
        var buyerlst = buyerrepo.findById(bid).orElseThrow(() -> new RuntimeException("Buyer id Not Found"));
        obj.setBuyerlst(buyerlst);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        obj.setPostdate(dateFormat.format(date));
        postfeedbackrepo.save(obj);
        return new ResponseEntity<>("Post Message Successfully", HttpStatus.OK);

    }
    @GetMapping("/GetPostFeedBack")
    public ResponseEntity<?> GetPostFeedBack() {
        var msglst = postfeedbackrepo.findAll();
        return new ResponseEntity<>(msglst, HttpStatus.OK);
    }

}
