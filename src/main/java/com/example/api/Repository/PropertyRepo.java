package com.example.api.Repository;

import com.example.api.Entity.PropertyMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepo extends JpaRepository<PropertyMaster,Integer> {


    List<PropertyMaster> findByPtype(String ptype);
}
