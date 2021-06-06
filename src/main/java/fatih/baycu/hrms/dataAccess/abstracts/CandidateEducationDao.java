package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.CandidateEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation,Integer> {
    List<CandidateEducation> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
