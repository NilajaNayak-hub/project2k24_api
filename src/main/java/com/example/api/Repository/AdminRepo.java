package com.example.api.Repository;

import com.example.api.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


public interface AdminRepo extends JpaRepository<Admin,Integer> {
}
