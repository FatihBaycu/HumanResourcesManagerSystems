package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.JobPostService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.business.validationRules.JobPostValidatorService;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.core.utilities.verificationtool.CodeGenerator;
import fatih.baycu.hrms.dataAccess.abstracts.JobPostDao;
import fatih.baycu.hrms.entities.concretes.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobPostManager implements JobPostService {
    private final JobPostDao jobPostDao;
    private final JobPostValidatorService jobPostValidatorService;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao, JobPostValidatorService jobPostValidatorService) {
        this.jobPostDao = jobPostDao;
        this.jobPostValidatorService = jobPostValidatorService;
    }

    @Override
    public Result add(JobPost jobPost) {
        Result result = BusinessEngine.run(jobPostValidatorService.isNullCheck(jobPost));
        if (!result.isSuccess()) {
            return result;
        }
        jobPost.setUid(CodeGenerator.generateUuidCode());
        jobPostDao.save(jobPost);
        return new SuccessResult(Messages.JobPostAdded);
    }

    @Override
    public Result changeActive(int postId) {
        JobPost jobPost = this.jobPostDao.getById(postId);
        Result result = BusinessEngine.run(checkJobPostIsExists(jobPost));
        if (!result.isSuccess()) {
            return result;
        }
        JobPost updatePost = jobPost;
        updatePost.setActivated(!updatePost.isActivated());
        this.jobPostDao.save(updatePost);
        return new SuccessResult(Messages.JobPostUpdated);
    }

    @Override
    public DataResult<List<JobPost>> getAll() {
        return new SuccessDataResult<>(jobPostDao.findAll());
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivated() {
        return new SuccessDataResult<>(jobPostDao.getByIsActivatedTrueOrderByCreatedDateDesc());
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivatedAndByDay(int day) {
        LocalDateTime finishDate = LocalDateTime.now().minusDays(day);
        return new SuccessDataResult<>(jobPostDao.getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(finishDate, LocalDateTime.now()));
    }

    @Override
    public DataResult<List<JobPost>> getAllByActivatedAndByEmployer(int employerId) {
        return new SuccessDataResult<>(jobPostDao.getByEmployer_IdAndIsActivatedTrue(employerId));
    }

    private Result checkJobPostIsExists(JobPost jobPost) {
        if (jobPost == null) {
            return new ErrorResult("İş ilanı mevcut değil");
        }
        return new SuccessResult();
    }
}
