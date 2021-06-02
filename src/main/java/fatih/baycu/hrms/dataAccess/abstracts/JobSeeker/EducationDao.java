package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
