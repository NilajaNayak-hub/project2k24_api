package com.example.api.Controller;

import com.example.api.Entity.PropertyMaster;
import com.example.api.Entity.PropertyPhoto;
import com.example.api.Repository.PropertyPhotoRepo;
import com.example.api.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class PropertyPhotoController {

    @Autowired
    private PropertyPhotoRepo propertyphotorepo;

    @Autowired
    private PropertyRepo propertyrepo;

    @PostMapping("/AddPropertyPhoto/{id}")
    public ResponseEntity<?> AddPropertyPhoto(@PathVariable Integer id, @RequestBody PropertyPhoto obj) {

        var propertyPhoto = propertyrepo.findById(id).orElseThrow(() -> new RuntimeException("Property id Not Found"));
        obj.setPropertymaster(propertyPhoto);
        propertyphotorepo.save(obj);
        return new ResponseEntity<>("Property Photo Uploaded Successfully", HttpStatus.OK);

    }
    @GetMapping("/GetPropertyImage")
    public ResponseEntity<?> GetPropertyImage() {
        var msglst = propertyphotorepo.findAll();
        return new ResponseEntity<>(msglst, HttpStatus.OK);
    }
}
