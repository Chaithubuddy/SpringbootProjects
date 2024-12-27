package com.chaithu.narvee.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.chaithu.narvee.Entity.PlanMaster;
import com.chaithu.narvee.Repo.PlanMasterRepo;

@Service
public class planServiceImpl implements planService {
	@Autowired
	private PlanMasterRepo planRepo;

	@Override
	public Map<Integer, String> getPlanCatergory() {
		List<PlanMaster> categories = planRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(a -> categoryMap.put(a.getPlanId(), a.getPlanName()));
		return categoryMap;
	}

	@Override
	public Boolean savePlan(PlanMaster plan) {
		PlanMaster save = planRepo.save(plan);
		return save.getPlanId() != null;
	}

	@Override
	public Boolean updatePlan(PlanMaster plan) {
		PlanMaster update = planRepo.save(plan);
		return update.getPlanId() != null;
	}

	@Override
	public Optional<PlanMaster> getPlaneById(Integer id) {
		Optional<PlanMaster> findByID = planRepo.findById(id);
		if (findByID.isPresent()) {
			return Optional.of(findByID.get());

		}
		return null;
	}

	@Override
	public Boolean DeletePlane(Integer id) {
		Boolean status = false;
		try {
			planRepo.deleteById(id);
			status = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<PlanMaster> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Boolean planStatusChange(Integer id, String status) {
		Optional<PlanMaster> findById = planRepo.findById(id);
		if (findById.isPresent()) {
			PlanMaster planMaster = findById.get();
			planMaster.setActiveSW(status);
			planRepo.save(planMaster);
			return true;
		}
		return false;
	}

}
