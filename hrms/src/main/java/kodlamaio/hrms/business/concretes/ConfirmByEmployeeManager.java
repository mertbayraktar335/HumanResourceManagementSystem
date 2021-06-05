package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {
	
	EmployerDao employerDao;
	EmployeeDao employeeDao;
	ConfirmByEmployeeDao confirmByEmployeeDao;
	
	
	@Autowired
	public ConfirmByEmployeeManager(EmployeeDao employeeDao ,EmployerDao employerDao,ConfirmByEmployeeDao confirmByEmployeeDao) {
		super();
		this.employerDao = employerDao;
		
		this.confirmByEmployeeDao=confirmByEmployeeDao;
		this.employeeDao=employeeDao;
	}

	

	@Override
	public Result isConfirmedByEmployee(int employerId,int employeeId,boolean isActive) {
		
		Employee employee = (employeeDao.findById(employeeId));
		ConfirmByEmployee confirmByEmployee = (this.confirmByEmployeeDao.findByEmployerId(employerId));
		confirmByEmployee.setEmployee(employee);
		confirmByEmployee.setConfirm(isActive);
		confirmByEmployee.setConfirmDate(LocalDateTime.now());
		confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("İşveren Onaylandı");
		
		
		
		
	
}

	@Override
	public Result TableSettler(Employer employer) {
		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
		confirmByEmployee.setEmployer(employer);
		confirmByEmployee.setConfirm(false);
		confirmByEmployeeDao.save(confirmByEmployee);
		
		
		return new SuccessResult("Tablo Oluşturuldu");
	}



	
}






	

