package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeekerDao;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.JobSeeker;
import fatih.baycu.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private UserDao userDao;
    private MernisServiceAdapter mernisServiceAdapter;
    private ActivationCodeService activationCodeService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,
                            UserDao userDao,
                            MernisServiceAdapter mernisServiceAdapter,
                            ActivationCodeService activationCodeService)
    {
        this.jobSeekerDao = jobSeekerDao;
        this.userDao=userDao;
        this.mernisServiceAdapter=mernisServiceAdapter;
        this.activationCodeService=activationCodeService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Listed");
    }

    public Result add(JobSeeker jobSeeker){

         if(checkValid(jobSeeker)==false){return new ErrorResult("boş alan kalmamalı");}
         if(checkExistByEmail(jobSeeker.getEmail())){return  new ErrorResult("email zaten mevcut");}
         if(checkExistByNatiolanityId(jobSeeker.getNatiolanityId())){return  new ErrorResult("bu tc zaten mevcut");}
         //if(mernisServiceAdapter.CheckIfRealPerson(jobSeeker)){return  new ErrorResult("Mernis doğrulaması başarısız.");}


            User user = new User();

            userDao.save(user);

            jobSeeker.setUserId(user.getId());

            ActivationCode activationCode=new ActivationCode();
            activationCodeService.sendVerifedCode(activationCode,user);

            activationCodeService.checkVerifedCode(activationCode,user,"");

            jobSeekerDao.save(jobSeeker);


            return new SuccessResult("Added");

    }

    @Override
    public Boolean checkExistByEmail(String email) {return jobSeekerDao.existsByEmail(email);}

    @Override
    public Boolean checkExistByNatiolanityId(String natiolanityId) {return jobSeekerDao.existsByNatiolanityId(natiolanityId);}


    @Override
    public Boolean checkEmailVerifedCode(JobSeeker jobSeeker) {

            activationCodeService.findActivationCodeByUserId(jobSeeker.getUserId());

        return null;
    }


    public boolean checkValid(JobSeeker jobSeeker){

        if(jobSeeker.getEmail() != null &&
                jobSeeker.getFirstName() != null &&
                jobSeeker.getLastName() != null &&
                jobSeeker.getPasswordHash() != null &&
                //jobSeeker.getBirthDate() != null &&
                jobSeeker.getNatiolanityId() != null){
            return true;
        }

        else
            return false;
    }


}
