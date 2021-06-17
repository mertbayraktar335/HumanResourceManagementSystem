  
package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisesConfirmByEmployee;

public interface JobAdvertisesConfirmByEmployeeDao extends JpaRepository<JobAdvertisesConfirmByEmployee, Integer>{
	
	JobAdvertisesConfirmByEmployee findByJobAdvertiseId(int jobAdvertiseId);
	List<JobAdvertisesConfirmByEmployee> findAllByIsConfirmed(boolean isConfirmed);

}