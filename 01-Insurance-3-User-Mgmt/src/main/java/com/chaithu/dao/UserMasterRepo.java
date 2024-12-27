package com.chaithu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.entity.UserMaster;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster, Integer> {

	public UserMaster findByMail(String mail);

	public UserMaster findByMailAndPassword(String email, String pwd);
}
