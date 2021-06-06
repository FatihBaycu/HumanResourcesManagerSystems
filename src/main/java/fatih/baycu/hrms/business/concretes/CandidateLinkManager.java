package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateLinkService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateLinkDao;
import fatih.baycu.hrms.entities.concretes.CandidateLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateLinkManager implements CandidateLinkService {
    private final CandidateLinkDao candidateLinkDao;
    @Autowired
    public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
        this.candidateLinkDao = candidateLinkDao;
    }

    @Override
    public Result add(CandidateLink candidateLink) {
        this.candidateLinkDao.save(candidateLink);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateLink> candidateLink) {
        candidateLinkDao.saveAll(candidateLink);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateLink>> getAll() {
        return new SuccessDataResult<>(this.candidateLinkDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateLinkDao.getAllByCandidateId(candidateId));
    }
}
