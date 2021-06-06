package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.CandidateExperience;


import java.util.List;

public interface CandidateExperienceService {
    Result add(CandidateExperience candidateExperience);
    Result addAll(List<CandidateExperience> candidateExperience);
    DataResult<List<CandidateExperience>> getAll();
    DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}
