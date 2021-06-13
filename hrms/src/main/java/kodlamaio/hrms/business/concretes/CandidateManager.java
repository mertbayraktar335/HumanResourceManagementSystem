package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.core.adapters.abstracts.MernisDemoService;
import kodlamaio.hrms.core.adapters.abstracts.RegexService;
import kodlamaio.hrms.core.adapters.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapters.concretes.VerificationCodeManager;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private MernisDemoService mernisDemoService;
	private RegexService regexService;
	private EmployeeDao employeeDao;
	private UserPhotoService userPhotoService;
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao, VerificationCodeService verificationCodeService,
			MernisDemoService mernisDemoService,RegexService regexService,EmployeeDao employeeDao,UserPhotoService userPhotoService) {
		super();
		this.candidateDao = candidateDao;
		
		this.verificationCodeService = verificationCodeService;
		this.mernisDemoService = mernisDemoService;	
		this.regexService = regexService;
		this.employeeDao=employeeDao;
		this.userPhotoService=userPhotoService;
	
	}

		
	

	@Override
	
	public Result add(Candidate candidate) {
		
		if(candidate.getFirstname().isEmpty()&&candidate.getLastname().isEmpty()
			&&candidate.getBirthDate().isEmpty()&&candidate.getIdentificationNumber().isEmpty()&&
			candidate.getEmail().isEmpty()) {
			return new ErrorResult("Bölümleri Boş Geçmeyiniz");
			
			}
		else if (!regexService.isPasswordForm(candidate.getPassword())){
			return new ErrorResult("Parola En Az 8 Karakter, Bir Küçük Bir Büyük ve Bir Özel Karakter İçermelidir");
		}
		else if (!regexService.isDateOfBirthForm(candidate.getBirthDate())) {
			return new ErrorResult("Doğum Tarihi Biçimi hatalı");
			
		}
		else if (!mernisDemoService.isValidNationalityIdentity(candidate.getIdentificationNumber())) {
			return new ErrorResult("Tc No Hatalı");
		}
		else if(!regexService.isEmailValid(candidate.getEmail())) {
			
			return new ErrorResult("Email Hatalı");
		}
			
			else if(!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
				return new ErrorResult("Şifreler Uyuşmuyor");
			}
		
		else if (candidateDao.findByEmailEquals(candidate.getEmail())!=null) {
		return new ErrorResult("Email Kullanımda");
		}
		else if(candidateDao.findByIdentificationNumberEquals(candidate.getIdentificationNumber())!=null) {
		return new ErrorResult("Bu tcno Kullanımda ");
		}
		else{
			this.candidateDao.save(candidate);
			this.verificationCodeService.createActivationCode(candidate);
			this.userPhotoService.photoTableSetter(candidate);
			return new SuccessResult("Kullanıcı sisteme kaydedildi.Fakat doğrulama yapılmadı. " + candidate.getEmail()
					+ "Adresine doğrulama kodu gönderildi");
		}
		

		
	}

	

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	

	@Override
	public DataResult<List<Candidate>> findAllByEmail(String email) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAllByEmail(email),"Listelendi");
		
	}
	@Override
	public DataResult<List<Candidate>> findAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), ("İş arayanlar listelendi"));
	
	}




	@Override
	public DataResult<Candidate> findByIdentificationNumber(String identificationNumber) {
		
		if(this.candidateDao.findByIdentificationNumber(identificationNumber)==null) {
			return new ErrorDataResult<Candidate>("TcNo Bulunamadı");
			
		}
		else {
			return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentificationNumber(identificationNumber),"Listelendi");
		}
		
	}


}

	

//if(Strings.isNullOrEmpty(candidate.getFirstname())) {
//return new ErrorResult("İsim Bölümü Boş Bırakılamaz");
//}
//else if (Strings.isNullOrEmpty(candidate.getLastname())) {
//return new ErrorResult("Soyisim Bölümü Boş Bırakılamaz");
//}
//else if(candidate.getBirthDate()==null) {
//return new ErrorResult("Doğum Tarihi Bölümü Boş Bırakılamaz");
//}
//else if(Strings.isNullOrEmpty(candidate.getEmail())) {
//return new ErrorResult("E-posta Bölümü Boş Bırakılamaz");
//}
//else if(Strings.isNullOrEmpty(candidate.getPassword())&&candidate.getPassword().length()<=6) {
//return new ErrorResult("Parola Bölümü 6 Karakterden Az Oluşamaz");
//}
//
//else if (!mernisDemoService.isValidNationalityIdentity(candidate.getIdentificationNumber() )) {
//return new ErrorResult("Kimlik No Doğrulaması Yapılamadı");
//}
//else if (candidateDao.findByEmailEquals(candidate.getEmail())!=null) {
//return new ErrorResult("Email Kullanımda");
//}
//else if(candidateDao.findByIdentificationNumber(candidate.getIdentificationNumber())!=null) {
//return new ErrorResult("Bu tcno Kullanımda ");
//}
//else if (isEmailValid(candidate.getEmail())) {
//	
//	
//	this.candidateDao.save(candidate);
//		
//		//User  savedUser = this.userDao.save(candidate);
//    	//this.candidateDao.save(candidate);
//		return new SuccessResult(candidate.getEmail() + " Adresine doğrulama kodu gönderildi");
//}
//
//else {
////Candidate verifyCandidate = new Candidate();
////verifyCandidate.setMailVerify(false);
//
//return new ErrorResult("Kullanıcı Bilgileri Geçersizdir");
//
//}
//User  savedUser = this.userDao.save(candidate);
//this.candidateDao.save(candidate);
