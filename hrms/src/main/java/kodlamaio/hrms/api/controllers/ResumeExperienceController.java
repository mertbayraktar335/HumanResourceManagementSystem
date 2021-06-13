package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeExperienceAddDto;

@RestController
@RequestMapping("/api/resumeExperience")
public class ResumeExperienceController {
	
	private ResumeExperienceService resumeExperienceService;

	public ResumeExperienceController(ResumeExperienceService resumeExperienceService) {
		super();
		this.resumeExperienceService = resumeExperienceService;
	}

	@PostMapping("/addExperience")
	public Result add(@RequestBody ResumeExperienceAddDto resumeExperienceAddDto) {
		return resumeExperienceService.add(resumeExperienceAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeExperienceAddDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeExperienceService.findAllByResumeId(resumeId);
	}

}
