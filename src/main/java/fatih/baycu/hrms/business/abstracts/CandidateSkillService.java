package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.CandidateSkill;

import java.util.List;

public interface CandidateSkillService {
    Result add(CandidateSkill candidateSkill);
    Result addAll(List<CandidateSkill> candidateSkill);
    DataResult<List<CandidateSkill>> getAll();
    DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId);

}
