package com.ashokit.Service;

import org.springframework.stereotype.Service;

import com.ashokit.Binding.AppDeterminationReq;
import com.ashokit.Binding.AppDeterminationRes;

@Service
public class AppDeterminationService {

	public AppDeterminationRes checkEligibility(AppDeterminationReq req) {
		
		AppDeterminationRes response = new AppDeterminationRes();
		 
		String status = req.getPlanName();
		
		    response.setPlanName(status);
		    response.setName(req.getName());
		    response.setSsn(req.getSsn());
		
		if("SNAP".equals(status)) {
			if(req.getIncome()<=200.00) {
				response.setBenefitAmt("150.00");
				response.setPlanStatus("APPROVED");
				response.setStartDate("25-02-2022");
				response.setEndDate("25-05-2022");
			}else {
				 response.setPlanStatus("DENIED");
				 response.setDenialReason("INCOME SHOULD BE LESS THAN 200");
				 
			}
		}else if("CCAP".equals(status)) {
			    if(req.getIncome()<=200.00 &&req.getKidsEligible()<=16) {
			    	response.setBenefitAmt("180.00");
					response.setPlanStatus("APPROVED");
					response.setStartDate("25-02-2022");
					response.setEndDate("25-05-2022");
			    }else {
			    	 response.setPlanStatus("DENIED");
					 response.setDenialReason("INCOME SHOULD BE LESS THAN 200 AND KIDS AGE SHOULD BE LESS THAN 16");
			    }
		}else if("MEDICAID".equals(status)) {
			    if(req.getIncome()<=300.00) {
			    	response.setBenefitAmt("170.00");
					response.setPlanStatus("APPROVED");
					response.setStartDate("25-02-2022");
					response.setEndDate("25-05-2022");
			    }else {
			    	 response.setPlanStatus("DENIED");
					 response.setDenialReason("INCOME SHOULD BE LESS THAN 300");
			    }
		}else if("MEDICARE".equals(status)) {
			if(req.getAge()>=65) {
				response.setBenefitAmt("130.00");
				response.setPlanStatus("APPROVED");
				response.setStartDate("25-02-2022");
				response.setEndDate("25-05-2022");
			}else {
				 response.setPlanStatus("DENIED");
				 response.setDenialReason("AGE SHOULD BE GREATER THAN 65");
			}
		}else if("KW".equals(status)) {
			if(req.getEmpStatus().equals("UNEMPLOYEE")) {
				response.setBenefitAmt("120.00");
				response.setPlanStatus("APPROVED");
				response.setStartDate("25-02-2022");
				response.setEndDate("25-05-2022");
			}else {
				 response.setPlanStatus("DENIED");
				 response.setDenialReason("A CITIZEN MUST AND SHOULD BE UNEMPLOYED");
				
			}		
		}
		return response;
	}
}
