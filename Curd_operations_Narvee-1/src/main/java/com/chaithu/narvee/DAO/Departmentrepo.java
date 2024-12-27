package com.chaithu.narvee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.Departmnet;

@Repository
public interface Departmentrepo extends JpaRepository<Departmnet, Integer> {

}
