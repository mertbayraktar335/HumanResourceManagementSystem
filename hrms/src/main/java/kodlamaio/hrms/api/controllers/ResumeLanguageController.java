package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLanguageAddDto;

@RestController
@RequestMapping("/api/resumeLanguage")
public class ResumeLanguageController {
	
private ResumeLanguageService resumeLanguageService;
	
	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		super();
		this.resumeLanguageService = resumeLanguageService;
	}


	@PostMapping("/addLanguage")
	public Result add(@RequestBody ResumeLanguageAddDto resumeLanguageAddDto) {
		return resumeLanguageService.add(resumeLanguageAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeLanguageAddDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeLanguageService.findAllByResumeId(resumeId);
	}

}
