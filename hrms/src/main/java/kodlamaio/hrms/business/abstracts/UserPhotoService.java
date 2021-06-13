package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

public interface UserPhotoService {
	
	Result saveImage(MultipartFile file, int userId);
	void photoTableSetter(User user);

}
