package com.example.narvee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.narvee.Entity.Passport;

@Repository
public interface IPassportRepo  extends JpaRepository<Passport,Integer>{
	
}
