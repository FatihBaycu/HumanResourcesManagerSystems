package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobExperience;

import java.util.List;

public interface JobExperienceService{

    DataResult<List<JobExperience>> getAll();

    Result add(JobExperience jobExperience);
    Result update(JobExperience jobExperience);
    Result delete(JobExperience jobExperience);



}
