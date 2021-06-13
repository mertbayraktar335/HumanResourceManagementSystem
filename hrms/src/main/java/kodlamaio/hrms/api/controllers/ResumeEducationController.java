package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeEducationAddDto;

@RestController
@RequestMapping("/api/resumeEducation")
public class ResumeEducationController {
	
	private ResumeEducationService resumeEducationService;

	@Autowired
	public ResumeEducationController(ResumeEducationService resumeEducationService) {
		super();
		this.resumeEducationService = resumeEducationService;
	}
	@PostMapping("/addEducation")
	public Result add(@RequestBody ResumeEducationAddDto resumeEducationAddDto) {
		return resumeEducationService.add(resumeEducationAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeEducationAddDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeEducationService.findAllByResumeId(resumeId);
	}
}
