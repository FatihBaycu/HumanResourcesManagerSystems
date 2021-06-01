package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.School;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();

    Result add(School school);
    Result update(School school);
    Result delete(School school);
}
