package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {
	public static boolean EmployerDomainCheck(Employer employer) {

        String[] dizi = employer.getEmail().split("@");
        String email=dizi[1];

        String[] dizi2 = employer.getWebAddress().split("www.");
        String domain =dizi2[1];

        if(email==domain) {
            return true;
        }
        return false;
    }
}
