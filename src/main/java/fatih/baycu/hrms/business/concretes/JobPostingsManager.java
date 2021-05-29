package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.JobPostingsService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.JobPostingsDao;
import fatih.baycu.hrms.entities.concretes.JobPostings;
import fatih.baycu.hrms.entities.concretes.dtos.JobPostingsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return new SuccessDataResult(this.jobPostingsDao.findAll(),"Listed");
    }

    @Override
    public Result add(JobPostings jobPostings) {
        this.jobPostingsDao.save(jobPostings);
        return new SuccessResult("Added");

    }

    @Override
    public DataResult<List<JobPostingsDetail>> findAllByActiveTrue() {
        return new SuccessDataResult(this.jobPostingsDao.findAllByActiveTrue(),"Listed");
    }

    @Override
    public DataResult<List<JobPostingsDetail>> findAllByActiveTrueOrderByDate() {

        Sort sort=Sort.by(Sort.Direction.DESC,"createdAt");
        return new SuccessDataResult<List<JobPostingsDetail>>(this.jobPostingsDao.findAllByActiveTrue(),"Listed");
    }

    @Override
    public DataResult<List<JobPostingsDetail>> findAllByActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult(this.jobPostingsDao.findAllByActiveTrueAndEmployerId(employerId),"Listed");
    }


}
