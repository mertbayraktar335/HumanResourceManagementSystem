package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertiseAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertiseDto;

public interface JobAdvertiseService {
	
	Result add(JobAdvertiseAddDto jobAdvertiseAddDto);
	
	Result deleteById(int id);
	
	DataResult<List<JobAdvertiseDto>> findAllByIsActive(boolean isActive);
	
	DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateDesc(boolean isActive);
	
	DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateAsc(boolean isActive);
	
	DataResult<List<JobAdvertiseDto>> findByIsActiveAndEmployer_CompanyName(boolean isActive,String employerName);
	
	Result isActive(int id,boolean isActive);

}
