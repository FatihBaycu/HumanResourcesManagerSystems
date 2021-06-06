package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateLanguageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateLanguageDao;
import fatih.baycu.hrms.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private final CandidateLanguageDao candidateLanguageDao;
    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateLanguage> candidateLanguage) {
        candidateLanguageDao.saveAll(candidateLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<>(this.candidateLanguageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateLanguageDao.getAllByCandidateId(candidateId));
    }
}
