package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobPostings;

import java.util.*;

public interface JobPostingsService {

    DataResult<List<JobPostings>> getAll();

    Result add(JobPostings jobPostings);

}
