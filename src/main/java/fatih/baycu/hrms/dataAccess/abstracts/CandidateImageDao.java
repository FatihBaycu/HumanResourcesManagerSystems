package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.CandidateImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateImageDao extends JpaRepository<CandidateImage,Integer> {
    List<CandidateImage> getAllByCandidateId(int candidateId);
}
