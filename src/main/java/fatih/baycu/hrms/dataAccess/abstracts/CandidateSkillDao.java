package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill,Integer> {
    List<CandidateSkill> getAllByCandidateId(int candidateId);
}
