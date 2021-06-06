package fatih.baycu.hrms.business.abstracts.auth;

import fatih.baycu.hrms.entities.concretes.Candidate;
import fatih.baycu.hrms.entities.dtos.RegisterForCandidateDtoForAuth;

public interface CandidateAuthService extends UserAuthService<RegisterForCandidateDtoForAuth, Candidate> {
}
