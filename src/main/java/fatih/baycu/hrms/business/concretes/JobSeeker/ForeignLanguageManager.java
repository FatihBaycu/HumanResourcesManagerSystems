package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.ForeignLanguageService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.ForeignLanguageDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.foreignLanguageDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.delete(foreignLanguage);
        return new SuccessResult(ResultMessages.deleted);
    }
}
