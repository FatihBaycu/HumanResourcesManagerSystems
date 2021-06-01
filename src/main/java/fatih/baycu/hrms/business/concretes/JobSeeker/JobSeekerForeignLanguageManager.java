package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.JobSeekerForeignLanguageService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.JobSeekerForeignLanguageDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeekerForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerForeignLanguageManager implements JobSeekerForeignLanguageService {

    private JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao;

    @Autowired
    public JobSeekerForeignLanguageManager(JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao) {
        this.jobSeekerForeignLanguageDao = jobSeekerForeignLanguageDao;
    }

    @Override
    public DataResult<List<JobSeekerForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerForeignLanguageDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        this.jobSeekerForeignLanguageDao.save(jobSeekerForeignLanguage);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        this.jobSeekerForeignLanguageDao.save(jobSeekerForeignLanguage);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        this.jobSeekerForeignLanguageDao.delete(jobSeekerForeignLanguage);
        return new SuccessResult(ResultMessages.deleted);
    }
}
