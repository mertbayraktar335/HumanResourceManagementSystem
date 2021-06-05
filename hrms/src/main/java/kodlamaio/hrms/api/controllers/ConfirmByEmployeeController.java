package kodlamaio.hrms.api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/confirm_by_employees")
public class ConfirmByEmployeeController {
	
	ConfirmByEmployeeService confirmByEmployeeService;

	public ConfirmByEmployeeController(ConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.confirmByEmployeeService = confirmByEmployeeService;
	}
	
	@PostMapping("/confirmEmployee")
	public Result isConfirmedByEmployee(@RequestParam int employerId, @RequestParam int employeeId, boolean isConfirmed) {
		
	    return confirmByEmployeeService.isConfirmedByEmployee(employerId, employeeId, isConfirmed);
	}
	
	
	

}
