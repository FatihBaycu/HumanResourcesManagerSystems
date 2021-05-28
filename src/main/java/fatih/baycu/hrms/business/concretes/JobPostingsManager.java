package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.JobPostingsService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobPostingsDao;
import fatih.baycu.hrms.entities.concretes.JobPostings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobPostingsManager implements JobPostingsService {

    private JobPostingsDao jobPostingsDao;

    @Autowired
    public JobPostingsManager(JobPostingsDao jobPostingsDao) {
        this.jobPostingsDao = jobPostingsDao;
    }

    @Override
    public DataResult<List<JobPostings>> getAll() {
        return null;
    }

    @Override
    public Result add(JobPostings jobPostings) {
        this.jobPostingsDao.save(jobPostings);
        return new SuccessResult("Added");

    }
}
