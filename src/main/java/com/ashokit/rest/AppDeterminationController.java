package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.Binding.AppDeterminationReq;
import com.ashokit.Binding.AppDeterminationRes;
import com.ashokit.Service.AppDeterminationService;

@RestController
public class AppDeterminationController {

	@Autowired
	private AppDeterminationService service;

	@PostMapping("/plan")
	public AppDeterminationRes CheckEligibility(AppDeterminationReq req) {
		return service.checkEligibility(req);

	}
}
