package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.JobPostings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingsDao extends JpaRepository<JobPostings,Integer> {

}
