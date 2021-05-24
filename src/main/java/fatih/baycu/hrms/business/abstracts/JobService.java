package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {

    DataResult<List<Job>> getAll();
    DataResult<List<Job>> getByJobName(String jobName);
    Result add(Job job);

}
