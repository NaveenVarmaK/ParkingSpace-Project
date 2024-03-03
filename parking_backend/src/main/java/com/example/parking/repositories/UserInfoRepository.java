package com.example.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parking.models.UserInfo;
  
import java.util.Optional; 
  
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> { 
    Optional<UserInfo> findByName(String username); 
}