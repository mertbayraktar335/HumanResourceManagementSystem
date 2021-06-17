package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisesConfirmByEmployeeService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertiseDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisesConfirmByEmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.JobAdvertise;
import kodlamaio.hrms.entities.concretes.JobAdvertisesConfirmByEmployee;
import kodlamaio.hrms.entities.dtos.JobAdvertisesConfirmByEmployeeGetDto;
@Service
public class JobAdvertisesConfirmByEmployeeManager implements JobAdvertisesConfirmByEmployeeService{

	private JobAdvertisesConfirmByEmployeeDao jobAdvertisesConfirmByEmployeeDao;
	private EmployeeDao employeeDao;
	private DtoConverterService dtoConverterService;
	private JobAdvertiseDao jobAdvertiseDao;
	
	@Autowired
	public JobAdvertisesConfirmByEmployeeManager(JobAdvertisesConfirmByEmployeeDao jobAdvertisesConfirmByEmployeeDao,
			EmployeeDao employeeDao, DtoConverterService dtoConverterService, JobAdvertiseDao jobAdvertiseDao) {
		super();
		this.jobAdvertisesConfirmByEmployeeDao = jobAdvertisesConfirmByEmployeeDao;
		this.employeeDao = employeeDao;
		this.dtoConverterService = dtoConverterService;
		this.jobAdvertiseDao = jobAdvertiseDao;
	}

	
	
	
	@Override
	public Result isConfirmedByEmployee(int jobAdvertiseId, int employeeId, boolean isConfirmed) {
		Employee employee = employeeDao.findById(employeeId);
		
		JobAdvertisesConfirmByEmployee confirmByEmployee = this.jobAdvertisesConfirmByEmployeeDao.findByJobAdvertiseId((jobAdvertiseId));
		confirmByEmployee.setEmployee(employee);
		confirmByEmployee.setConfirmed(isConfirmed);
		confirmByEmployee.setConfirmDate(LocalDateTime.now());
		jobAdvertisesConfirmByEmployeeDao.save(confirmByEmployee);
		
		
		JobAdvertise passiveAdvertise = jobAdvertiseDao.findById(jobAdvertiseId);
		passiveAdvertise.setActive(isConfirmed);
		jobAdvertiseDao.save(passiveAdvertise);
			
	
		
	
	return new SuccessResult("İşveren başarılı bir şekilde onaylandı");
	}
	

	@Override
	public DataResult<List<JobAdvertisesConfirmByEmployeeGetDto>> findAllByIsConfirmed(boolean isConfirmed) {
		return new SuccessDataResult<List<JobAdvertisesConfirmByEmployeeGetDto>>(dtoConverterService.entityToDto(jobAdvertisesConfirmByEmployeeDao.findAllByIsConfirmed(isConfirmed),JobAdvertisesConfirmByEmployeeGetDto.class)
				,"Onay listesi oluşturuldu");
	}
	
	@Override
	public void confirmTableSetter(JobAdvertise jobAdvertise) {
		JobAdvertisesConfirmByEmployee confirmByEmployee = new JobAdvertisesConfirmByEmployee();
		confirmByEmployee.setJobAdvertise(jobAdvertise);
		confirmByEmployee.setConfirmed(false);
		jobAdvertisesConfirmByEmployeeDao.save(confirmByEmployee);
	}
	
}