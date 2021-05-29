package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.JobPostings;

import fatih.baycu.hrms.entities.concretes.dtos.JobPostingsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingsDao extends JpaRepository<JobPostings,Integer> {

    @Query("select new fatih.baycu.hrms.entities.concretes.dtos.JobPostingsDetail(id, employer.companyName, job.jobName, active, numberOfEmployee, applicationDeadline,createdAt) from JobPostings where active=true")
    List<JobPostingsDetail> findAllByActiveTrue();

    @Query("select new fatih.baycu.hrms.entities.concretes.dtos.JobPostingsDetail(id, employer.companyName, job.jobName, active, numberOfEmployee, applicationDeadline,createdAt) from JobPostings where active=true and employer.id=:id")
    List<JobPostingsDetail> findAllByActiveTrueAndEmployerId(@Param("id") int id);




}
