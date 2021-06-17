package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployersConfirmByEmployeeGetDto;

public interface EmployersConfirmByEmployeeService {
	
	Result TableSettler(Employer employer);
	
	Result isConfirmedByEmployee(int employerId, int employeeId, boolean isConfirmed);
	DataResult<List<EmployersConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed);

}
