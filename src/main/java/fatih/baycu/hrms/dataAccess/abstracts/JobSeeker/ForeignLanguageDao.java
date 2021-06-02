package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer> {
}
