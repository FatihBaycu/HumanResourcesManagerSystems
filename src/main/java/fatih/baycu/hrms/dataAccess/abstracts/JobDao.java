package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobDao extends JpaRepository<Job, Integer> {

    List<Job> findByJobName(String jobName);
}