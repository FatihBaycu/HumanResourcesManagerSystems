package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeekerDao;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.JobSeeker;
import fatih.baycu.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobSeekerManager implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    public DataResult<List<JobSeeker>> getAll() {
        var result = this.jobSeekerDao.findAll();

        if (result.isEmpty())
            return new ErrorDataResult<>("Liste boş");

        return new SuccessDataResult<>(result, "Listelendi");
    }

    public DataResult<JobSeeker> getByIdentityNumber(String natiolanityId) {
        var result = this.jobSeekerDao.findByNatiolanityId(natiolanityId);

        return result != null ? new SuccessDataResult<>(result, "Kullanıcı mevcut") : new ErrorDataResult<>("Kullanıcı bulunamadı");
    }

    public Result add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Eklendi");
    }

    public Result update(JobSeeker jobSeeker) {
        return null;
    }

    public Result delete(JobSeeker jobSeeker) {
        return null;
    }

    public Boolean checkExistByEmail(String email) {return jobSeekerDao.existsByEmail(email);}

    public Boolean checkExistByNatiolanityId(String natiolanityId) {return jobSeekerDao.existsByNatiolanityId(natiolanityId);}

}