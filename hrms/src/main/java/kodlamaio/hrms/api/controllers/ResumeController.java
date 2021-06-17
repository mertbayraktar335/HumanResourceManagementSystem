package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;
@RestController
@CrossOrigin
@RequestMapping("/resumes")
public class ResumeController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/addresume")
	public Result add(@RequestBody ResumeGetDto resumeGetDto) {
		return resumeService.add(resumeGetDto);
	}
	@PostMapping("/updateresume")
	public Result update(@RequestBody ResumeUpdateDto resumeUpdateDto,int resumeId, int candidateId) {
		return resumeService.update(resumeUpdateDto, resumeId, candidateId);
	}
	
	@GetMapping("/findbycandidateandresume")
	
	public Result findAllByIdAndCandidateId(@RequestParam int id, @RequestParam int candidateId) {
		return resumeService.findAllByIdAndCandidateId(id, candidateId);
	}
}
	

