package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailService {
	void sendEmailVerify(User user, String code);
	

}
