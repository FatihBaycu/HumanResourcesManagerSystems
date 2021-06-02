package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getAll();

    Result add(Education education);
    Result update(Education education);
    Result delete(Education education);
}
