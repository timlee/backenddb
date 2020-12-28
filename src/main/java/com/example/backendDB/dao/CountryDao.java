package com.example.backendDB.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendDB.pojo.Country;

@Repository
public interface CountryDao extends JpaRepository<Country, Integer> {

}
