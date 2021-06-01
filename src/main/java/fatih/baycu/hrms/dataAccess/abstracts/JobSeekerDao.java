package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {

    Boolean existsByEmail(String email);
    Boolean existsByNatiolanityId(String natiolanityId);
    JobSeeker findByNatiolanityId(String natiolanityId);



}
