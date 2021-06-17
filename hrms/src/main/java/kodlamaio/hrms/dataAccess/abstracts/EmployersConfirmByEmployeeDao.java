package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployersConfirmByEmployee;

public interface EmployersConfirmByEmployeeDao extends JpaRepository<EmployersConfirmByEmployee, Integer>{
	
	EmployersConfirmByEmployee findByEmployerId(int employerId);
	List<EmployersConfirmByEmployee> findAllByIsConfirmed(boolean isConfirmed);

}