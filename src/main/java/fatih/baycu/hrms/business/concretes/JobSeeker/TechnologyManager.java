package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.TechnologyService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.TechnologyDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }


    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<>(this.technologyDao.findAll(),ResultMessages.listed);
    }

    @Override
    public Result add(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(Technology technology) {
        this.technologyDao.delete(technology);
        return new SuccessResult(ResultMessages.deleted);
    }
}
