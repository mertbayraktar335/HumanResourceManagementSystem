package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.adapters.abstracts.RegexService;
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
	private RegexService regexService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,RegexService regexService) {
		super();
		this.employeeDao = employeeDao;
		this.regexService = regexService;
	}

	@Override
	public DataResult<List<Employee>> findAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),("Personeller listelendi"));
	}

	@Override
	public Result add(Employee employee) {
		if(employee.getFirstName().isEmpty()||employee.getLastName().isEmpty()||employee.getEmail().isEmpty()||employee.getPassword().isEmpty()) {
				return new ErrorResult("Bölümleri Boş Geçmeyiniz");
				
				}
		else if(!regexService.isPasswordForm(employee.getPassword())) {
			return new ErrorResult("Parola En Az 8 Karakter, Bir Küçük Bir Büyük ve Bir Özel Karakter İçermelidir");
		}
		else if(!employee.getPassword().equals(employee.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		else {
			this.employeeDao.save(employee);
		}
			
		return new SuccessResult("Personel eklendi");
	}

}
