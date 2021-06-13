package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterAddDto;

@RestController
@RequestMapping("/api/resumeCoverLetters")
public class ResumeCoverLetterController {
	
	private ResumeCoverLetterService resumeCoverLetterService;

	@Autowired
	public ResumeCoverLetterController(ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeCoverLetterService = resumeCoverLetterService;
	}
	@PostMapping("/addCoverLetter")
	public Result add(@RequestBody ResumeCoverLetterAddDto resumeCoverLetterAddDto) {
		return resumeCoverLetterService.add(resumeCoverLetterAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeCoverLetterAddDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeCoverLetterService.findAllByResumeId(resumeId);
	}
}
