package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobSeeker;
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

    @PostMapping()
    public Result<JobSeeker> add(@RequestBody JobSeeker jobSeeker){
        return  jobSeekerService.add(jobSeeker);

    }

    @GetMapping("/get-by-email")
    public Boolean checkExistByEmail(String email){
        return jobSeekerService.checkExistByEmail(email);
    }

    @GetMapping("/exist-by-natiolanityid")
    public Boolean checkExistByNatiolanityId(String natiolanityId){
        return jobSeekerService.checkExistByNatiolanityId(natiolanityId);
    }

}
