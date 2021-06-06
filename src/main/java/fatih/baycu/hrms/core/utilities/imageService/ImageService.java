package fatih.baycu.hrms.core.utilities.imageService;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    DataResult<?> save(MultipartFile file);
}
