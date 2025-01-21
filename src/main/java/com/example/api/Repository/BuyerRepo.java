package com.example.api.Repository;

import com.example.api.Entity.BuyerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<BuyerMaster,Integer> {
}
