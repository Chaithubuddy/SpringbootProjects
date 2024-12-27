package com.chaithu.narvee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.Passport;

@Repository
public interface IPassportRepo  extends JpaRepository<Passport, Integer>{

}
