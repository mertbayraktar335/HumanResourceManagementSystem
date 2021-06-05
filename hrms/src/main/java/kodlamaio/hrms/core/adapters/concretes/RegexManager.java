package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.RegexService;

@Service
public class RegexManager implements RegexService {

	@Override
	public boolean isEmailValid(String emailInput) {
		String emailpattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(emailpattern, Pattern.CASE_INSENSITIVE);
			return pattern.matcher(emailInput).find();
		
	}
	@Override
	public boolean isFirstNameForm(String firstNameForm) {
		String regex = "[A-Z][a-zA-Z]*";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstNameForm);
        return matcher.matches();
	}

	@Override
	public boolean isLastNameForm(String lastNameForm) {
		String regex = "[A-Z]+[a-zA-Z]*";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lastNameForm);
        return matcher.matches();
	}

	@Override
	public boolean isDateOfBirthForm(String dateOfBirthForm) {
		String regex = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

	    Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirthForm);
        return matcher.matches();
	}

    	@Override
    	public boolean isPhoneNumberForm(String phoneNumberForm) {
    		  String regex = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$";

    		    Pattern pattern = Pattern.compile(regex);
    	        Matcher matcher = pattern.matcher(phoneNumberForm);
    	        return matcher.matches();
    	}
		@Override
		public boolean isPasswordForm(String passwordForm) {
			String regex = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*([^\\w\\s]|[_]))\\S{8,}$";

		    Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(passwordForm);
	        return matcher.matches();
		}
		@Override
		public boolean isCompanyNameForm(String companyNameForm) {
			String regex = "[A-Z][a-zA-Z]*";

		    Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(companyNameForm);
	        return matcher.matches();
		}
		@Override
		public boolean isWebAddressForm(String webAddressForm) {
			String webAddressPattern = "^[A-Z0-9._%+-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
			Pattern pattern = Pattern.compile(webAddressPattern, Pattern.CASE_INSENSITIVE);
				return pattern.matcher(webAddressForm).find();
		
		}

}
