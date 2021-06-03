package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeekerDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeeker;
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

    public DataResult<JobSeeker> getById(int id) {
        var result = this.jobSeekerDao.findById(id);

        return result.isEmpty()
                ? new ErrorDataResult<>("İş Arayan bulunamadı")
                : new SuccessDataResult<>(result.get(), "Bulundu");
    }

    public DataResult<JobSeeker> getByIdentityNumber(String natiolanityId) {
        var result = this.jobSeekerDao.findByNatiolanityId(natiolanityId);

        return result != null ? new SuccessDataResult<>(result, "Kullanıcı mevcut") : new ErrorDataResult<>("Kullanıcı bulunamadı");
    }

    public Result add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult(ResultMessages.added);
    }

    public Result update(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult(ResultMessages.updated);
    }

    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult(ResultMessages.deleted);

    }

    public Boolean checkExistByEmail(String email) {
        return jobSeekerDao.existsByEmail(email);
    }

    public Boolean checkExistByNatiolanityId(String natiolanityId) {
        return jobSeekerDao.existsByNatiolanityId(natiolanityId);
    }

}