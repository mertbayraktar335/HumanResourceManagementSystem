package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

public interface ResumeSkillService {
	
	Result add(ResumeSkillDto resumeSkillDto);
	DataResult<List<ResumeSkillDto>> findAllByResumeId(int resumeId);

}
