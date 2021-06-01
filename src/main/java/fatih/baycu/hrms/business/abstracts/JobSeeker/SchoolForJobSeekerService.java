package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolForJobSeeker;

import java.util.List;

public interface SchoolForJobSeekerService {

    DataResult<List<SchoolForJobSeeker>> getAll();

    Result add(SchoolForJobSeeker schoolForJobSeeker);
    Result update(SchoolForJobSeeker schoolForJobSeeker);
    Result delete(SchoolForJobSeeker schoolForJobSeeker);
}
