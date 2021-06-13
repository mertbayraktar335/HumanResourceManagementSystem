package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLinkAddDto;

@RestController
@RequestMapping("/api/resumeLink")
public class ResumeLinkController {
	
private ResumeLinkService resumeLinkService;
	
	@Autowired
	public ResumeLinkController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}


	@PostMapping("/addLink")
	public Result add(@RequestBody ResumeLinkAddDto resumeLinkAddDto) {
		return resumeLinkService.add(resumeLinkAddDto);
}
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeLinkAddDto>> findAllByResumeId(@RequestParam int resumeId){
		return resumeLinkService.findAllByResumeId(resumeId);
	}

}
