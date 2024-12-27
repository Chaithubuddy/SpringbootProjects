package com.chaithu.narvee.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.PlanMaster;

@Repository
public interface PlanMasterRepo extends JpaRepository<PlanMaster, Integer> {

}
