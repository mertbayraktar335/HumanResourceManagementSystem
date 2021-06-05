package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmaiManager implements EmailService {

	@Override
	public void sendEmailVerify(User user, String code) {
		// TODO Auto-generated method stub
		
	}

}
