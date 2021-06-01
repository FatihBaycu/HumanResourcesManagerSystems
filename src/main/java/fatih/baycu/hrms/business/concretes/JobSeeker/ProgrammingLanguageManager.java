package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.ProgrammingLanguageService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.ProgrammingLanguageDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {


    private ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getAll() {
        return new SuccessDataResult<>(this.programmingLanguageDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguageDao.save(programmingLanguage);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguageDao.save(programmingLanguage);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguageDao.delete(programmingLanguage);
        return new SuccessResult(ResultMessages.deleted);
    }
}
