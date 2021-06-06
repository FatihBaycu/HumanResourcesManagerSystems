package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateEducationService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateEducationDao;
import fatih.baycu.hrms.entities.concretes.CandidateEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateEducationManager implements CandidateEducationService {
    private final CandidateEducationDao candidateEducationDao;

    @Autowired
    public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
        this.candidateEducationDao = candidateEducationDao;
    }

    @Override
    public Result addAll(List<CandidateEducation> candidateEducation) {
        candidateEducationDao.saveAll(candidateEducation);
        return new SuccessResult();
    }

    @Override
    public Result add(CandidateEducation candidateEducation) {
        this.candidateEducationDao.save(candidateEducation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateEducation>> getAll() {
        return new SuccessDataResult<>(this.candidateEducationDao.findAll());
    }

    @Override
    public DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
        return new SuccessDataResult<>(this.candidateEducationDao.getAllByCandidateIdOrderByGraduationYear(candidateId), Messages.EducationListed);
    }
}
