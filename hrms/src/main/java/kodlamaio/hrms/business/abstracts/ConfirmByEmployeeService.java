package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface ConfirmByEmployeeService {
	
	Result TableSettler(Employer employer);
	
	Result isConfirmedByEmployee(int employerId, int employeeId, boolean isConfirmed);

}
