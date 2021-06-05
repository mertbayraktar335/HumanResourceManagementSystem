package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
     
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return employeeService.findAll();
	}
	
	@PostMapping("/add")
     public Result add(@RequestBody Employee employee) {
    	 return employeeService.add(employee);
     }
     
}
