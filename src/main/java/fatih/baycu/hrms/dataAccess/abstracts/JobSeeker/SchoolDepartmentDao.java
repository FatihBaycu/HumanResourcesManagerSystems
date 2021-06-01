package fatih.baycu.hrms.dataAccess.abstracts.JobSeeker;

import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment,Integer> {
}
