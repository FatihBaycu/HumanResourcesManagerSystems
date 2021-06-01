package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolForJobSeekerService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.SchoolForJobSeekerDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolForJobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolForJobSeekerManager implements SchoolForJobSeekerService {

    private SchoolForJobSeekerDao schoolForJobSeekerDao;

    @Autowired
    public SchoolForJobSeekerManager(SchoolForJobSeekerDao schoolForJobSeekerDao) {
        this.schoolForJobSeekerDao = schoolForJobSeekerDao;
    }

    @Override
    public DataResult<List<SchoolForJobSeeker>> getAll() {
        return new SuccessDataResult<List<SchoolForJobSeeker>>(this.schoolForJobSeekerDao.findAll(),ResultMessages.listed);
    }

    @Override
    public Result add(SchoolForJobSeeker schoolForJobSeeker) {
        this.schoolForJobSeekerDao.save(schoolForJobSeeker);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(SchoolForJobSeeker schoolForJobSeeker) {
        this.schoolForJobSeekerDao.save(schoolForJobSeeker);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(SchoolForJobSeeker schoolForJobSeeker) {
        this.schoolForJobSeekerDao.delete(schoolForJobSeeker);
        return new SuccessResult(ResultMessages.added);
    }
}
