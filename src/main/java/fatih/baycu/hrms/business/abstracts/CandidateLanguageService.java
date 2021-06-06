package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.CandidateLanguage;


import java.util.List;

public interface CandidateLanguageService {
    Result add(CandidateLanguage candidateLanguage);
    Result addAll(List<CandidateLanguage> candidateLanguage);
    DataResult<List<CandidateLanguage>> getAll();
    DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
