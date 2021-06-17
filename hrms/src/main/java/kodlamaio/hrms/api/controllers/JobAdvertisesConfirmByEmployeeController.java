package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisesConfirmByEmployeeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertisesConfirmByEmployeeGetDto;

@RestController
@RequestMapping("/api/jobAdvertisesConfirmByEmployee")
public class JobAdvertisesConfirmByEmployeeController {
	
	private JobAdvertisesConfirmByEmployeeService jobAdvertisesConfirmByEmployeeService;

	@Autowired
	public JobAdvertisesConfirmByEmployeeController(
			JobAdvertisesConfirmByEmployeeService jobAdvertisesConfirmByEmployeeService) {
		super();
		this.jobAdvertisesConfirmByEmployeeService = jobAdvertisesConfirmByEmployeeService;
	}

	@GetMapping("/findAllByIsConfirmed")
	public DataResult<List<JobAdvertisesConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed){
	
		return jobAdvertisesConfirmByEmployeeService.findAllByIsConfirmed(isConfirmed);
	}
	
	@PutMapping("/isConfirmedByEmployee")
	public Result isConfirmedByEmployee(int jobAdvertiseId, int employeeId, boolean isConfirmed) {
		
		return jobAdvertisesConfirmByEmployeeService.isConfirmedByEmployee(jobAdvertiseId, employeeId, isConfirmed);
	}
}