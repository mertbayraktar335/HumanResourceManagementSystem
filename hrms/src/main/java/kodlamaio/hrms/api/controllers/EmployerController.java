package kodlamaio.hrms.api.controllers;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
	

@RestController
@CrossOrigin
	@RequestMapping("/api/employers")
	public class EmployerController {
	

		EmployerService employerService;

		@Autowired
		public EmployerController(EmployerService employerService) {
			super();
			this.employerService = employerService;
		}
		
		 @GetMapping("/getall")
		 public DataResult<List<Employer>> getAll(){
			 return employerService.findAll(); 
		 }
		@PostMapping("/add")
		public Result add(@RequestBody Employer employer) {
			return employerService.add(employer);
		}
		
		
		
	}



