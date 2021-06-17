package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersConfirmByEmployeeService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployersConfirmByEmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployersConfirmByEmployee;
import kodlamaio.hrms.entities.dtos.EmployersConfirmByEmployeeGetDto;


@Service
public class EmployersConfirmByEmployeeManager implements EmployersConfirmByEmployeeService {
	
	EmployerDao employerDao;
	EmployeeDao employeeDao;
	EmployersConfirmByEmployeeDao employersConfirmByEmployeeDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public EmployersConfirmByEmployeeManager(EmployeeDao employeeDao ,EmployerDao employerDao,EmployersConfirmByEmployeeDao employersConfirmByEmployeeDao,DtoConverterService dtoConverterService) {
		super();
		this.employerDao = employerDao;
		
		this.employersConfirmByEmployeeDao=employersConfirmByEmployeeDao;
		this.employeeDao=employeeDao;
		this.dtoConverterService = dtoConverterService;
	}

	

	@Override
	public Result isConfirmedByEmployee(int employerId,int employeeId,boolean isActive) {
		
		Employee employee = (employeeDao.findById(employeeId));
		EmployersConfirmByEmployee employersConfirmByEmployee = (this.employersConfirmByEmployeeDao.findByEmployerId(employerId));
		employersConfirmByEmployee.setEmployee(employee);
		employersConfirmByEmployee.setConfirmed(isActive);
		employersConfirmByEmployee.setConfirmDate(LocalDateTime.now());
		employersConfirmByEmployeeDao.save(employersConfirmByEmployee);
		return new SuccessResult("İşveren Onaylandı");
		
		
		
		
	
}

	@Override
	public Result TableSettler(Employer employer) {
		EmployersConfirmByEmployee confirmByEmployee = new EmployersConfirmByEmployee();
		confirmByEmployee.setEmployer(employer);
		confirmByEmployee.setConfirmed(false);
		employersConfirmByEmployeeDao.save(confirmByEmployee);
		
		
		return new SuccessResult("Tablo Oluşturuldu");
	}



	@Override
public DataResult<List<EmployersConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed) {
		
		return new SuccessDataResult<List<EmployersConfirmByEmployeeGetDto>>(dtoConverterService.entityToDto(employersConfirmByEmployeeDao.findAllByIsConfirmed(isConfirmed),EmployersConfirmByEmployeeGetDto.class),"Onaylar Listelendi");
	}



	
}






	

