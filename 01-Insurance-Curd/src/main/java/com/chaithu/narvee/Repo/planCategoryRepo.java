package com.chaithu.narvee.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.PlanCategory;

@Repository
public interface planCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
