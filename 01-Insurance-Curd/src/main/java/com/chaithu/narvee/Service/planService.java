package com.chaithu.narvee.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.chaithu.narvee.Entity.PlanMaster;

public interface planService {

	public abstract Map<Integer, String> getPlanCatergory();
	
	public abstract  Boolean savePlan(PlanMaster plan);
	public abstract  Boolean updatePlan(PlanMaster plan);
	
	public abstract Optional<PlanMaster> getPlaneById(Integer id) ;
	public abstract Boolean DeletePlane(Integer id);
	
	public List<PlanMaster> getAllPlans();
	
	public  Boolean planStatusChange(Integer id,String status);
	
	
	
	
	

}
