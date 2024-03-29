package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.CandidateExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience,Integer> {
    List<CandidateExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
