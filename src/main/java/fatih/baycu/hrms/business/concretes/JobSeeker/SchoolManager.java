package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.SchoolDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(this.schoolDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult(ResultMessages.added);

    }

    @Override
    public Result update(School school) {
        this.schoolDao.save(school);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(School school) {
        this.schoolDao.delete(school);
        return new SuccessResult(ResultMessages.deleted);
    }
}
