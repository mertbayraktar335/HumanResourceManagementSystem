package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertise;
import kodlamaio.hrms.entities.dtos.JobAdvertisesConfirmByEmployeeGetDto;

public interface JobAdvertisesConfirmByEmployeeService {
	
	Result  isConfirmedByEmployee(int jobAdvertiseId, int employeeId,boolean isConfirmed);
	void  confirmTableSetter(JobAdvertise jobAdvertise);
	DataResult<List<JobAdvertisesConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed);

}