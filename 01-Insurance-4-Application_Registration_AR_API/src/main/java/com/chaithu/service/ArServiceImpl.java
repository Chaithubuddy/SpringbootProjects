package com.chaithu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chaithu.bindings.CitizenApp;
import com.chaithu.entity.CitizenAppEntity;
import com.chaithu.repository.Citizenrepository;

@Service
public class ArServiceImpl implements ArService {

	@Autowired
	private Citizenrepository appRepo;

	@Override
	public Integer createApplication(CitizenApp app) {

		String endpontUrl = "http://localhost:8080/ssn/{ssn}";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity(endpontUrl, String.class, app.getSsn());
		String stateName = forEntity.getBody();
		if ("New jersey".equals(stateName)) {

			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(app, entity);
			entity.setStateName(stateName);
			CitizenAppEntity save = appRepo.save(entity);

			return save.getAppld();

		}

		return 0;
	}

}
