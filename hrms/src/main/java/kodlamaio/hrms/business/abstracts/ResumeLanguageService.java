package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLanguageAddDto;

public interface ResumeLanguageService {
	
	Result add(ResumeLanguageAddDto resumeLanguageAddDto);
	DataResult<List<ResumeLanguageAddDto>> findAllByResumeId(int resumeId);

}
