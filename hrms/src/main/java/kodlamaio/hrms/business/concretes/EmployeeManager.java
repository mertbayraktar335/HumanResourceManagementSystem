package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> findAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),("Personeller listelendi"));
	}

	@Override
	public Result add(Employee employee) {
		if(employee.getFirstName().isEmpty()&&employee.getLastName().isEmpty()&&employee.getEmail().isEmpty()) {
				return new ErrorResult("Bölümleri Boş Geçmeyiniz");
				
				}
		else this.employeeDao.save(employee);
		
			
			
		return new SuccessResult("Personel eklendi");
	}

}
