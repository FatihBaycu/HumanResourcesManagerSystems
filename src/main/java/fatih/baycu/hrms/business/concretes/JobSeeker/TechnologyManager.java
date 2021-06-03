package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.TechnologyService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.TechnologyDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }


    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<>(this.technologyDao.findAll(),ResultMessages.listed);
    }

    public DataResult<Technology> getById(int id) {
        var result = this.technologyDao.findById(id);

        return result.isEmpty()
                ? new ErrorDataResult<>("İş Arayan bulunamadı")
                : new SuccessDataResult<>(result.get(), "Bulundu");
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
