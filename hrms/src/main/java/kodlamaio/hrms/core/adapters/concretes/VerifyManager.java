package kodlamaio.hrms.core.adapters.concretes;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.VerifyService;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerifyManager implements VerifyService{

	private VerificationCodeDao verificationCodeDao;
	
	public VerifyManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}
	@Override
	
		public Result activateUser(String activationCode) {
			
			if(verificationCodeDao.findByCodeEquals(activationCode)==null){
				
				return new ErrorResult("Kullanıcı Aktivastonu Başarısız");
				
			}
			else { 
				VerificationCode verificationCode = verificationCodeDao.findByCodeEquals(activationCode);
				verificationCode.setVerified(true);
				verificationCode.setVerifyDate(LocalDateTime.now());
				verificationCodeDao.save(verificationCode);
				
				return new SuccessResult("Kullanıcı aktivasyonu gerçekleşti");
						
			
			
			}
}
}
