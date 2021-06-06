package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateSkillService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateSkillDao;
import fatih.baycu.hrms.entities.concretes.CandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateSkillManager implements CandidateSkillService {

    private final CandidateSkillDao candidateSkillDao;

    @Autowired
    public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
        this.candidateSkillDao = candidateSkillDao;
    }

    @Override
    public Result add(CandidateSkill candidateSkill) {
        this.candidateSkillDao.save(candidateSkill);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateSkill> candidateSkill) {
        candidateSkillDao.saveAll(candidateSkill);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateSkill>> getAll() {
        return new SuccessDataResult<>(this.candidateSkillDao.findAll());
    }

    @Override
    public DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateSkillDao.getAllByCandidateId(candidateId));
    }
}
