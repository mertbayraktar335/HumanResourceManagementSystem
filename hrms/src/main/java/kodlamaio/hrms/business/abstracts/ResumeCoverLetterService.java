package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterAddDto;

public interface ResumeCoverLetterService {
	
	Result add(ResumeCoverLetterAddDto resumeCoverLetterAddDto);
	DataResult<List<ResumeCoverLetterAddDto>> findAllByResumeId(int resumeId);

}
