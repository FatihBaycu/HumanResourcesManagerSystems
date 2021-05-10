package fatih.baycu.hrms.business.concretes;


import fatih.baycu.hrms.business.abstracts.JobService;
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
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }
}
