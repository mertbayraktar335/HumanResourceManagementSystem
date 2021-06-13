package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserPhotoService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.utilities.CloudinaryService;
import kodlamaio.hrms.dataAccess.abstracts.UserPhotoDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserPhoto;

@Service
public class UserPhotoManager implements UserPhotoService{

	private UserPhotoDao userPhotoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public UserPhotoManager(UserPhotoDao userPhotoDao, CloudinaryService cloudinaryService) {
		super();
		this.userPhotoDao = userPhotoDao;
		this.cloudinaryService = cloudinaryService;
	}
	
	
	@Override
			public Result saveImage(MultipartFile file, int userId) {
			@SuppressWarnings("unchecked")
			Map<?, String> uploader = (Map<?, String>)cloudinaryService.save(file).getData();
			String imageUrl= uploader.get("url");
			UserPhoto userPhoto= userPhotoDao.findByUserId(userId);
			userPhoto.setPhotoUrl(imageUrl);
			userPhotoDao.save(userPhoto);
			return new SuccessResult("Fotoğraf eklendi");
					
	}
	
	
	@Override
	public void photoTableSetter(User user) {

		UserPhoto userPhoto=new UserPhoto();
		userPhoto.setUser(user);
		userPhotoDao.save(userPhoto);
		
	}
	}


