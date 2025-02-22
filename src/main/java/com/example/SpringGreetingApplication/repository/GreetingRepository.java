package com.example.SpringGreetingApplication.repository;

import com.example.SpringGreetingApplication.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
