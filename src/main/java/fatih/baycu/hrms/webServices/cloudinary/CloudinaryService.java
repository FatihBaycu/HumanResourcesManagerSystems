package fatih.baycu.hrms.webServices.cloudinary;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;


public class CloudinaryService {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "fbaycu",
            "api_key", "144375851265239",
            "api_secret", "1tGCmfgiMM6LWgu9J2AJyvUKQXU"));


}
