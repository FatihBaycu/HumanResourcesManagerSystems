package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolForJobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolForJobSeekerDao extends JpaRepository<SchoolForJobSeeker,Integer> {
}
