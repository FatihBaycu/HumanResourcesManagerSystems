package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.CandidateEducation;

import java.util.List;

public interface CandidateEducationService {
    Result add(CandidateEducation candidateEducation);
    Result addAll(List<CandidateEducation> candidateEducation);
    DataResult<List<CandidateEducation>> getAll();
    DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
