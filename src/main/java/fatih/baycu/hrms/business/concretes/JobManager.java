package fatih.baycu.hrms.business.concretes;


import fatih.baycu.hrms.business.abstracts.JobService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobDao;
import fatih.baycu.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class JobManager implements JobService {

    private  JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Listed");
    }

    @Override
    public DataResult<List<Job>> getByJobName(String jobName) {
        return new SuccessDataResult<List<Job>>(this.jobDao.findByJobName(jobName));
    }

    @Override
    public Result add(Job job) {
       jobDao.save(job);
        return null;
    }
}
