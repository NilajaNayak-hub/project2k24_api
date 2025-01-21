package com.example.api.Repository;

import com.example.api.Entity.SellerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<SellerMaster,Integer> {
}
