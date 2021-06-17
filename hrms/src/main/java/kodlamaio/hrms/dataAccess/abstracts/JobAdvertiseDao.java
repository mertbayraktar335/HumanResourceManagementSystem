package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertise;

public interface JobAdvertiseDao extends JpaRepository<JobAdvertise, Integer> {
	
	//JobAdvertise isActive(int id, boolean isActive);
	
	List<JobAdvertise> findAllByIsActive(boolean isActive);
	
	List<JobAdvertise> findByIsActiveOrderByCreatedDateDesc(boolean isActive);
	
	List<JobAdvertise> findByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	
	List<JobAdvertise> findByIsActiveOrderByCreatedDateAsc(boolean isActive);
	
	JobAdvertise findById(int id);
	
	JobAdvertise deleteById(int id);
	
	
	
	
	
	
	
	

}
