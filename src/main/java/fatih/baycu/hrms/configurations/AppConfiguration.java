package fatih.baycu.hrms.configurations;

import fatih.baycu.hrms.core.utilities.imageService.ImageService;
import fatih.baycu.hrms.core.utilities.imageService.cloudinary.CloudinaryImageManager;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgfimpyp9",
                "api_key", "559497441591421",
                "api_secret", "qXZGvlycICDV5FBK3b4KEO0Oz4M"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}
