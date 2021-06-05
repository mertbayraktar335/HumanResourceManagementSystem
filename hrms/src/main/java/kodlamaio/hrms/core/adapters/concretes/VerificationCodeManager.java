package kodlamaio.hrms.core.adapters.concretes;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	VerificationCodeDao verificationCodeDao;
	

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		
	}

	@Override
	public DataResult<List<VerificationCode>> findAllByCode() {

		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll(),
				"Basariyla listelendi");
	}

	
	String generatedCode = "";

	@Override
	public String createActivationCode(User user) {

		for (int i = 0; i == 0; i = 0) {
			generatedCode = randomCodeGenarator(20); // Random kod olustur
			if (findByCode(generatedCode) == null) {
				break;
			}
		}
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(generatedCode);
		verificationCode.setUser(user);
		verificationCodeDao.save(verificationCode);
		return generatedCode;
	}


	

	@Override
	public VerificationCode findByCode(String code) {

		return this.verificationCodeDao.findByCode(code);
	}

	private final String whatsUp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private SecureRandom mixer = new SecureRandom();

	private String randomCodeGenarator(int lenght) {
		StringBuilder randomValueConstructor = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			randomValueConstructor.append(whatsUp.charAt(mixer.nextInt(whatsUp.length())));
		}
		return randomValueConstructor.toString();
	}

	
	}

	
	

