package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateExperienceService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateExperienceDao;
import fatih.baycu.hrms.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateExperienceManager implements CandidateExperienceService {
    private final CandidateExperienceDao candidateExperienceDao;

    @Autowired
    public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
        this.candidateExperienceDao = candidateExperienceDao;
    }

    @Override
    public Result addAll(List<CandidateExperience> candidateExperience) {
        candidateExperienceDao.saveAll(candidateExperience);
        return new SuccessResult();
    }

    @Override
    public Result add(CandidateExperience candidateExperience) {
        this.candidateExperienceDao.save(candidateExperience);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateExperience>> getAll() {
        return new SuccessDataResult<>(this.candidateExperienceDao.findAll());
    }

    @Override
    public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
        return new SuccessDataResult<>(this.candidateExperienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
    }


}
