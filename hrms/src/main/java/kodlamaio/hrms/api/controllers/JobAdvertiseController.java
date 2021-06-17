package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertiseService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertiseAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertiseDto;

@RestController
@CrossOrigin
@RequestMapping("/job_advertises")

public class JobAdvertiseController {
	
	JobAdvertiseService jobAdvertiseService;

	public JobAdvertiseController(JobAdvertiseService jobAdvertiseService) {
		super();
		this.jobAdvertiseService = jobAdvertiseService;
	}
	
	@GetMapping("/getbyisactive")
	public DataResult<List<JobAdvertiseDto>> findAllByIsActive(){
		return jobAdvertiseService.findAllByIsActive();
	}
	@PostMapping("/activedeactive")
	public Result isActive(int id, boolean status) {
		return jobAdvertiseService.isActive(id, status);
		
	}
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertiseAddDto jobAdvertiseAddDto) {
		return jobAdvertiseService.add(jobAdvertiseAddDto);
		
	}
	 @GetMapping("/getbydateDesc")
	 public DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateDesc(){
		 return jobAdvertiseService.findByIsActiveOrderByCreatedDateDesc();
	 }
	@DeleteMapping("/deletebyid")
	public Result deleteById(@RequestParam int  id) {
		return jobAdvertiseService.deleteById(id);
	}
	@GetMapping("/getbycompanynameandisactive")
	public DataResult<List<JobAdvertiseDto>> findByIsActiveAndEmployer_CompanyName(String employerName){
		return findByIsActiveAndEmployer_CompanyName(employerName);
	}
	@GetMapping("/getbydateAsc")
	DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateAsc(){
	return jobAdvertiseService.findByIsActiveOrderByCreatedDateAsc();
	}

}
