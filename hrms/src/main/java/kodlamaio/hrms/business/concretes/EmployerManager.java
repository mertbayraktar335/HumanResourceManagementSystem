package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersConfirmByEmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.abstracts.RegexService;
import kodlamaio.hrms.core.adapters.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer; 

@Service
public class EmployerManager implements EmployerService {

	private VerificationCodeService verificationCodeService;
	private EmployerDao employerDao;
	private RegexService regexService;
	private EmployersConfirmByEmployeeService employersConfirmByEmployeeService;
	
	
	@Autowired
	public EmployerManager(VerificationCodeService verificationCodeService, EmployerDao employerDao,
			RegexService regexService, EmployersConfirmByEmployeeService employersConfirmByEmployeeService) {
		super();
		this.verificationCodeService = verificationCodeService;
		this.employerDao = employerDao;
		this.regexService = regexService;
		this.employersConfirmByEmployeeService = employersConfirmByEmployeeService;
	}

	@Override
	public DataResult<List<Employer>> findAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),("İş verenler listelendi"));
		
	}

	@Override
	public Result add(Employer employer) {
		if(employer.getCompanyName().isEmpty()&&employer.getEmail().isEmpty()&&employer.getPassword().isEmpty()
				&&employer.getPhoneNumber().isEmpty()&&employer.getWebAddress().isEmpty()){
			return new ErrorResult("Boş Alan Bırakmayınız!!");
		}
			
			else if(!regexService.isCompanyNameForm(employer.getCompanyName())) {
				return new ErrorResult("Şirket Adı Hatalı Girildi");
			}
			else if(!regexService.isEmailValid(employer.getEmail())) {
				return new ErrorResult("Email Hatalı Girildi");
			}
			else if(!regexService.isPasswordForm(employer.getPassword())) {
				return new ErrorResult("Parola En Az 8 Karakter, Bir Küçük Bir Büyük ve Bir Özel Karakter İçermelidir");
			}
			else if(!regexService.isPhoneNumberForm(employer.getPhoneNumber())){
				return new ErrorResult("Telefon Numarası Hatalı Girildi");
			}
			else if(!regexService.isWebAddressForm(employer.getWebAddress())) {
				return new ErrorResult("Web Adresi Hatalı Girildi");
		}
			else if(employerDao.findByCompanyNameEquals(employer.getCompanyName())!=null) {
				return new ErrorResult("Şirket İsmi Kullanımda");
				
			}
			else if(employerDao.findByEmailEquals(employer.getEmail())!=null) {
				return new ErrorResult("Bu Email Kullanımda");
			}
			else if(employerDao.findByWebAddressEquals(employer.getWebAddress())!=null) {
				return new ErrorResult("Web Adresi Kullanımda");
			}
			else if(!employer.getPassword().equals(employer.getPasswordRepeat())) {
				return new ErrorResult("Şifreler Uyuşmuyor");
			}
			else {
			this.employerDao.save(employer);
			this.verificationCodeService.createActivationCode(employer);
			this.employersConfirmByEmployeeService.TableSettler(employer);
		
			return new SuccessResult (employer.getEmail() + " Adresine doğrulama kodu gönderildi");
			
			}
		}
		   
	   private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

		public boolean isEmailValid(String emailInput) {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
			return pattern.matcher(emailInput).find();
	}

		

}
