package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.Candidate;

import java.util.Optional;

public interface CandidateDao extends UserDao<Candidate>{
    Optional<Candidate> findByNationalIdentity(String nationalIdentity);
}
