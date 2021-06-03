package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.JobExperienceService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.JobExperienceDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<>(this.jobExperienceDao.findAll(), ResultMessages.listed);
    }

    @Override
    public DataResult<List<JobExperience>> findAllByJobSeekerId(Sort sort, int jobSeekerId) {
        sort=Sort.by(Sort.Direction.DESC,"endDate");
        return new SuccessDataResult<>(this.jobExperienceDao.findAllByJobSeekerId(sort,jobSeekerId));
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult(ResultMessages.updated);    }

    @Override
    public Result delete(JobExperience jobExperience) {
        this.jobExperienceDao.delete(jobExperience);
        return new SuccessResult(ResultMessages.deleted);    }
}
