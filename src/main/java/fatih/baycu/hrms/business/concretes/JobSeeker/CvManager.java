package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.CvService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.CvDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<>(this.cvDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(Cv cv) {
        this.cvDao.delete(cv);
        return new SuccessResult(ResultMessages.deleted);
    }
}
