package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {


}
