package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@RestController
@RequestMapping("/api/resumeSkill")
public class ResumeSkillController {
	

	private ResumeSkillService resumeSkillService;
	
	@Autowired
	public ResumeSkillController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}


	@PostMapping("/addresume")
	public Result add(@RequestBody ResumeSkillDto resumeSkillAddDto) {
		return resumeSkillService.add(resumeSkillAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeSkillDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeSkillService.findAllByResumeId(resumeId);
	}
	
}
