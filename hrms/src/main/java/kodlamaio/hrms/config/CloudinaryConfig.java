package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import kodlamaio.hrms.core.utilities.CloudinaryManager;
import kodlamaio.hrms.core.utilities.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	
	@Value("${cld.access-key}")
	String apiKey;
	
	
	@Value("${cld.secret-key")
	String apiSecretKey;
	
	
	
	@Bean
    public Cloudinary cloudinaryUser(){
		
		    
		    return new Cloudinary(ObjectUtils.asMap(
		                "cloud_name", "hrmsmbcloud",
		                "api_key", "125734492844965",
		                "api_secret", "GUN52zEFe7DBZdypJw-_7C7qRPg"));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }

}
