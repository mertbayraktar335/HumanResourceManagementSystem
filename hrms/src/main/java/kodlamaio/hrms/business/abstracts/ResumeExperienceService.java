package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.dtos.ResumeExperienceAddDto;

public interface ResumeExperienceService {
	Result add(ResumeExperienceAddDto resumeExperienceAddDto);
	DataResult<List<ResumeExperienceAddDto>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeExperienceAddDto>> findByResumeIdOrderByEndDateDesc(int resumeId);
	Result addAll(List<ResumeExperience> resumeExperience);

}
