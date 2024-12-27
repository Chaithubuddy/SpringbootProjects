package com.chaithu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.entity.CitizenAppEntity;

@Repository
public interface Citizenrepository extends JpaRepository<CitizenAppEntity, Serializable>{

}
