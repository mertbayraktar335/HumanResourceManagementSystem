package kodlamaio.hrms.core.adapters.abstracts;

public interface RegexService {
	
	boolean isEmailValid(String emailInput);
	boolean isFirstNameForm(String firstNameForm);
	boolean isLastNameForm(String lastNameForm);
	boolean isDateOfBirthForm(String dateOfBirthForm);
	boolean isPhoneNumberForm(String phoneNumberForm);
	boolean isPasswordForm(String passwordForm);
	boolean isCompanyNameForm(String companyNameForm);
	boolean isWebAddressForm(String webAddressForm);
	
}
