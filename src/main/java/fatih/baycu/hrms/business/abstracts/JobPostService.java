package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobPost;

import java.util.List;

public interface JobPostService {
    public Result add(JobPost jobPost);

    Result changeActive(int postId);

    public DataResult<List<JobPost>> getAll();

    public DataResult<List<JobPost>> getAllByActivated();

    public DataResult<List<JobPost>> getAllByActivatedAndByDay(int day);

    public DataResult<List<JobPost>> getAllByActivatedAndByEmployer(int employerId);
}
