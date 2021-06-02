package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.EducationService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.EducationDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),ResultMessages.listed);
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(Education education) {
        this.educationDao.delete(education);
        return new SuccessResult(ResultMessages.added);
    }
}
