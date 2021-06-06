package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.entities.concretes.Candidate;
import fatih.baycu.hrms.entities.dtos.CvDto;

public interface CandidateService extends UserService<Candidate> {
    DataResult<CvDto> getResumeByCandidateId(int candidateId);
    DataResult<Candidate> getById(int id);
}
