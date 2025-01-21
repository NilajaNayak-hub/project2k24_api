package com.example.api.Repository;

import com.example.api.Entity.PostMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostMessageRepo extends JpaRepository<PostMessage,Integer> {
}
