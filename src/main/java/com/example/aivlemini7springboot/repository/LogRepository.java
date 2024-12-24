package com.example.aivlemini7springboot.repository;

import com.example.aivlemini7springboot.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, String> {


}
