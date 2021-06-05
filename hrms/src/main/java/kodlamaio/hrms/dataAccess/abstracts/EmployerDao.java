package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	//Employer findByWebAddress(String webAddress);
	Employer findByEmailEquals(String email);
	Employer findByCompanyNameEquals(String companyName);
	Employer findByWebAddressEquals(String webAddress);
	Employer findById(int id);
	//Employer isConfirmed(boolean isConfirmed);
}
