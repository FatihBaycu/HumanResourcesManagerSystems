package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.EmployerService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.EmployerDao;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.Employer;
import fatih.baycu.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserDao userDao;
    private ActivationCodeService activationCodeService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,UserDao userDao,ActivationCodeService activationCodeService) {
        this.employerDao = employerDao;
        this.userDao=userDao;
        this.activationCodeService=activationCodeService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {

        if(checkEmployer(employer)){
            User user =new User();
            userDao.save(user);
            employer.setUserId(user.getId());



            employerDao.save(employer);
            return new SuccessResult("Added");
        }

        return new ErrorResult("Not Added");

    }

    public boolean checkEmployer(Employer employer){

        if(
                employer.getEmail()!=null&&
                employer.getCompanyName()!=null&&
                employer.getPhoneNumber()!=null&&
                employer.getPhoneNumber()!=null&&
                employer.getPasswordHash()!=null
        ){
            return true;
        }
        else
            return false;


    }

}
