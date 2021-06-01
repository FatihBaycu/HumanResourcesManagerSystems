package fatih.baycu.hrms.business.concretes;

import com.cloudinary.Cloudinary;
import fatih.baycu.hrms.business.abstracts.ImageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.webServices.cloudinary.CloudinaryService;

import java.util.List;


public class ImageManager implements ImageService {

    private CloudinaryService cloudinaryService=new CloudinaryService();



    Cloudinary cloudinary=new Cloudinary();


    @Override
    public DataResult<List> getAll() {
        return null;
    }

    @Override
    public Result add() {


        return null;
    }

    @Override
    public Result update() {
        return null;
    }

    @Override
    public Result delete() {
        return null;
    }

    @Override
    public Result manipulationImage() {
        return null;
    }
}
