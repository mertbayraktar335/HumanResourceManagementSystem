package kodlamaio.hrms.core.utilities;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;

public interface CloudinaryService {
	
	DataResult<?> save(MultipartFile file);

}
