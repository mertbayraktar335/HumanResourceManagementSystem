package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee, Integer> {
	
	//ConfirmByEmployee findById(User user, Candidate candidate, Employer employer);
	
	ConfirmByEmployee findByEmployerId(int employerId);
	

}
