package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
	
	List<Candidate> findAllByEmail(String email);
	Candidate findByEmailEquals(String email);
	Candidate findByIdentificationNumberEquals(String identificationNumber);
	Candidate findByIdentificationNumber(String identificationNumber);

	//Candidate findByIdentificationNumber(String identificationNumber);
	

}
