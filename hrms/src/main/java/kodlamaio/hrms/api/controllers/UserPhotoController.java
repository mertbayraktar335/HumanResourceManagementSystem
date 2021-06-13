package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.core.results.Result;

@RestController
@RequestMapping("/api/userPhoto")
public class UserPhotoController {
	
	private UserPhotoService userPhotoService;

	@Autowired
	public UserPhotoController(UserPhotoService userPhotoService) {
		super();
		this.userPhotoService = userPhotoService;
	}
	
	@PutMapping("/addPhoto")
	
	public Result saveImage(MultipartFile file, int userId) {
		
		return userPhotoService.saveImage(file, userId);
		
	
	}
	

}
