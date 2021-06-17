package kodlamaio.hrms.api.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployersConfirmByEmployeeService;
import kodlamaio.hrms.core.results.Result;

@RestController
@RequestMapping("/api/confirm_by_employees")
public class EmployersConfirmByEmployeeController {
	
	EmployersConfirmByEmployeeService confirmByEmployeeService;

	public EmployersConfirmByEmployeeController(EmployersConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.confirmByEmployeeService = confirmByEmployeeService;
	}
	
	@PostMapping("/confirmEmployee")
	public Result isConfirmedByEmployee(@RequestParam int employerId, @RequestParam int employeeId, boolean isConfirmed) {
		
	    return confirmByEmployeeService.isConfirmedByEmployee(employerId, employeeId, isConfirmed);
	}
	
	
	

}
