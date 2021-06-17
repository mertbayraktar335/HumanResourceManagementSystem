package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeEducation;
import kodlamaio.hrms.entities.dtos.ResumeEducationAddDto;

public interface ResumeEducationService {
	Result add(ResumeEducationAddDto resumeEducationAddDto);
	DataResult<List<ResumeEducationAddDto>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeEducationAddDto>> findByResumeIdOrderByEndDateDesc(int resumeId);
	Result addAll(List<ResumeEducation> resumeEducation);

}
