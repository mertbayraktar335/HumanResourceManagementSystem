package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobType")
public class JobTypeController {
	
	private JobTypeService jobTypeService;

	@Autowired
	public JobTypeController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobType jobType) {
		
		return jobTypeService.add(jobType);
		
		}
	@GetMapping("/findAll")
	DataResult<List<JobType>> findAll(){
		
		return jobTypeService.findAll();
	}

}