package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.GraduateAddDto;

@RestController
@RequestMapping("/api/graduate")
public class GraduateController {
	
private GraduateService graduateService;
	
	@Autowired
	public GraduateController(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
	@PostMapping("/addGraduate")
	public Result add(@RequestBody GraduateAddDto graduateAddDto) {
		return graduateService.add(graduateAddDto);
	}

}
