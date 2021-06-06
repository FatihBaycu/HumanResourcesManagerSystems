package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Candidate;

public interface CandidateValidatorService {
    Result candidateNullCheck(Candidate candidate);
    Result nationalIdValid (String nationalIdentity);
}
