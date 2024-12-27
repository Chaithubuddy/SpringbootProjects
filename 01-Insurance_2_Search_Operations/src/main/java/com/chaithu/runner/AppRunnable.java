package com.chaithu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.chaithu.dao.EligibiltyDetailsRepo;
import com.chaithu.entity.EligibiltyDetails;

@Component
public class AppRunnable implements ApplicationRunner {

	@Autowired
	private EligibiltyDetailsRepo eligibleRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibiltyDetails entity1 = new EligibiltyDetails();

		entity1.setEligId(1);
		entity1.setName("Chaithu");
		entity1.setEmail("Chaithu@gmail.com");
		entity1.setMobile(9100881724L);
		entity1.setGender('m');
		entity1.setSsn(123432L);
		entity1.setPlanName("ACAP");
		entity1.setPlanStatus("Approved");
		eligibleRepo.save(entity1);

		EligibiltyDetails entity2 = new EligibiltyDetails();
		entity2.setEligId(2);
		entity2.setName("Lavanya");
		entity2.setEmail("lavanay@gmail.com");
		entity2.setMobile(9100881724L);
		entity2.setGender('F');
		entity2.setSsn(223432L);
		entity2.setPlanName("BCAP");
		entity2.setPlanStatus("Approved");
		eligibleRepo.save(entity2);

		EligibiltyDetails entity3 = new EligibiltyDetails();
		entity3.setEligId(3);
		entity3.setName("Prassu");
		entity3.setEmail("prassu@gmail.com");
		entity3.setMobile(9100881724L);
		entity3.setGender('F');
		entity3.setSsn(333432L);
		entity3.setPlanName("CCAP");
		entity3.setPlanStatus("pending");

		eligibleRepo.save(entity3);

	}

}
