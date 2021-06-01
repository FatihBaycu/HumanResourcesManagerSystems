package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeekerForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerForeignLanguageDao extends JpaRepository<JobSeekerForeignLanguage,Integer> {
}
