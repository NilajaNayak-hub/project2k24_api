package com.example.api.Controller;

import com.example.api.Entity.PropertyMaster;
import com.example.api.Entity.SellerMaster;
import com.example.api.Repository.PropertyRepo;
import com.example.api.Repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")
public class PropertyController {

    @Autowired
    private PropertyRepo propertyrepo;

    @Autowired
    private SellerRepo sellerrepo;

    @PostMapping("/AddProperty/{id}")
    public ResponseEntity<?> AddProperty(@PathVariable Integer id,@RequestBody PropertyMaster obj) {

        Random rnd = new Random();
        int SPId = rnd.nextInt(100000, 999999);
        obj.setSpid(SPId);
//        obj.setPstatus("Active");

        var sellerlst = sellerrepo.findById(id).orElseThrow(() -> new RuntimeException("Seller id Not Found"));
        obj.setSellermaster(sellerlst);

        propertyrepo.save(obj);
        return new ResponseEntity<>("Property Added Successfully & Property Id:"+SPId, HttpStatus.OK);

    }
    @GetMapping("/GetProperty")
    public ResponseEntity<?> GetProperty() {
        var propertylst = propertyrepo.findAll();
        return new ResponseEntity<>(propertylst, HttpStatus.OK);
    }

    @PutMapping("/UpdateProperty")
    public ResponseEntity<?> UpdateProperty(@RequestBody PropertyMaster obj)
    {
        var propertyinfo=propertyrepo.findById(obj.getSpid()).orElseThrow(()->new RuntimeException("Property Id Not Found"));
        propertyinfo.setPname(obj.getPname());
        propertyinfo.setPtype(obj.getPtype());
        propertyinfo.setPdetail(obj.getPdetail());
        propertyinfo.setCost(obj.getCost());
//        propertyinfo.setPlocation(obj.getPlocation());
        propertyinfo.setPstatus(obj.getPstatus());
        propertyinfo.setVstatus(obj.getVstatus());
        propertyinfo.setLongitude(obj.getLongitude());
        propertyinfo.setLatitude(obj.getLatitude());
        propertyrepo.save(propertyinfo);
        return  new ResponseEntity<>("Property Details Updated Successfully",HttpStatus.OK);
    }

    @GetMapping("/GetSearchProperty/{ptype}")
    public ResponseEntity<?> GetSearchProperty(@PathVariable String ptype) {
        var propertylst = propertyrepo.findByPtype(ptype);
        return new ResponseEntity<>(propertylst, HttpStatus.OK);
    }

    @PutMapping("/VerifyProperty")
    public ResponseEntity<?> VerifyProperty(@RequestBody PropertyMaster obj)
    {
        var propertyinfo=propertyrepo.findById(obj.getSpid()).orElseThrow(()->new RuntimeException("Property Id Not Found"));
        propertyinfo.setVerifystatus("Verified");
        propertyrepo.save(propertyinfo);
        return  new ResponseEntity<>("Property Verified Successfully",HttpStatus.OK);
    }
}
