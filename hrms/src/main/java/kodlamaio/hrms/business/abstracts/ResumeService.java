package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

public interface ResumeService {
	
	Result add(ResumeAddDto resumeAddDto);
	Result update(ResumeUpdateDto resumeUpdateDto,int resumeId ,int candidateId);
	Result findAllByIdAndCandidateId(int id,int candidateId);

}
