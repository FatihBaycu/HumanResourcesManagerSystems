package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeekerForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerForeignLanguageService{

    DataResult<List<JobSeekerForeignLanguage>> getAll();

    Result add(JobSeekerForeignLanguage jobSeekerForeignLanguage);
    Result update(JobSeekerForeignLanguage jobSeekerForeignLanguage);
    Result delete(JobSeekerForeignLanguage jobSeekerForeignLanguage);

}
