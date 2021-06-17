package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.dtos.ResumeLinkAddDto;

public interface ResumeLinkService {
	Result add(ResumeLinkAddDto resumeLinkAddDto);
	DataResult<List<ResumeLinkAddDto>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeLink> resumeLink);

}
