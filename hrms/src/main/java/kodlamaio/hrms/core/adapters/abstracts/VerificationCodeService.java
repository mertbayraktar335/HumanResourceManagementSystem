package kodlamaio.hrms.core.adapters.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
    DataResult<List<VerificationCode>> findAllByCode();
    VerificationCode findByCode(String code);
	String createActivationCode(User user);
	
	

	
	
	

}
