package fatih.baycu.hrms.business.abstracts;

import com.cloudinary.Cloudinary;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;

import java.util.List;

public interface ImageService {

    DataResult<List> getAll();
    Result add();
    Result update();
    Result delete();
    Result manipulationImage();



}
