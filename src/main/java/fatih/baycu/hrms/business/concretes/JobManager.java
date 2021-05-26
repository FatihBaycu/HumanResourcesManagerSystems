package fatih.baycu.hrms.business.concretes;


import fatih.baycu.hrms.business.abstracts.JobService;
import fatih.baycu.hrms.core.utilities.results.*;
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
    public DataResult<Job> getByJobName(String jobName) {

        return new SuccessDataResult<Job>(this.jobDao.findByJobName(jobName));
    }

    @Override
    public Result add(Job job) {
        if(!checkExistJobName(job.getJobName())){
            jobDao.save(job);
            return new SuccessResult("Added");
        }
        else
        return new ErrorResult("Not Added");
    }

    @Override
    public Boolean checkExistJobName(String jobName) {

        if(jobDao.existsByJobName(jobName)){
            return true;
        }
        else
            return false;
        }
}
