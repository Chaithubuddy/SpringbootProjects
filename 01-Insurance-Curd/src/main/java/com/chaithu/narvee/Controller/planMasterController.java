package com.chaithu.narvee.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.narvee.Entity.PlanMaster;
import com.chaithu.narvee.Service.planService;
import com.chaithu.narvee.constants.AppConstants;
import com.chaithu.narvee.pros.AppProperties;

@RestController
@RequestMapping
public class planMasterController {

	private planService planService;

	private Map<String, String> messages;

	public planMasterController(planService planService, AppProperties appProps) {
		this.planService = planService;
		this.messages = appProps.getMessages();

	}

	@GetMapping("/Categories")
	public ResponseEntity<Map<Integer, String>> getCategory() {
		Map<Integer, String> catagorie = planService.getPlanCatergory();
		return new ResponseEntity<>(catagorie, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody PlanMaster planMaster) {
		String responseMsg = AppConstants.EMPTY_STR;
		Boolean isSaved = planService.savePlan(planMaster);

		if (isSaved) {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_SUCCES);
		} else {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);

	}

	@GetMapping("/plans")
	public ResponseEntity<List<PlanMaster>> Plans() {
		List<PlanMaster> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);

	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanMaster> editPlan(@PathVariable Integer planId) {
		Optional<PlanMaster> plan = planService.getPlaneById(planId);
		if (plan.isPresent()) {
			return new ResponseEntity<>(plan.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody PlanMaster plan) {
		boolean isUpdated = planService.updatePlan(plan);
		String responseMsg = AppConstants.EMPTY_STR;
		if (isUpdated) {
			responseMsg = messages.get(AppConstants.PLAN_UPDATE_SUCCESFULLY);
			return new ResponseEntity<>(responseMsg, HttpStatus.OK);
		} else {
			responseMsg = messages.get(AppConstants.PLAN_UPDATE_FAIL);
			return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = planService.DeletePlane(planId);
		String responseMsg = AppConstants.EMPTY_STR;
		if (isDeleted) {
			responseMsg = messages.get(AppConstants.PLAN_DELETE_SUCCESS);

			return new ResponseEntity<>(responseMsg, HttpStatus.OK);
		} else {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
			return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/status-change{planId}/{status}")
	public ResponseEntity<String> statusChange(@RequestParam Integer planId, @RequestParam String status) {
		String responseMsg = AppConstants.EMPTY_STR;
		boolean isStatusChanged = planService.planStatusChange(planId, status);

		if (isStatusChanged) {
			responseMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
			return new ResponseEntity<>(responseMsg, HttpStatus.OK);
		} else {
			responseMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
			return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
		}
	}

}
