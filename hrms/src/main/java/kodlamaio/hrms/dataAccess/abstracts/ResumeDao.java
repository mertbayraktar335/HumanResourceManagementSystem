package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	
	Resume findById(int id);
	List<Resume> findByIdAndCandidateId(int id,int candidateId);
	Resume findByResumeNameAndCandidateId(String resumeName,int candidateId);
	

}
