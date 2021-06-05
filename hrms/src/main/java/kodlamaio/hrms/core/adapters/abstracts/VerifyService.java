package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.results.Result;

public interface VerifyService {
	Result activateUser(String activationCode);

}
