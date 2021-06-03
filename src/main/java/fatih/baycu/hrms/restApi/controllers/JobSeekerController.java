package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeeker;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/job-seekers")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping()
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }

    @GetMapping("/get-by-email")
    public Boolean checkExistByEmail(String email){
        return this.jobSeekerService.checkExistByEmail(email);
    }

    @GetMapping("/exist-by-natiolanityid")
    public Boolean checkExistByNatiolanityId(String natiolanityId){return this.jobSeekerService.checkExistByNatiolanityId(natiolanityId);}

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker){
        this.jobSeekerService.add(jobSeeker);
        return new SuccessResult(ResultMessages.added);
    }


    @PostMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker){
        this.jobSeekerService.update(jobSeeker);
        return new SuccessResult(ResultMessages.updated);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody JobSeeker jobSeeker){
        this.jobSeekerService.delete(jobSeeker);
        return new SuccessResult(ResultMessages.deleted);
    }

}
