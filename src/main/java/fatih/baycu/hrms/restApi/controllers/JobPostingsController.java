package fatih.baycu.hrms.restApi.controllers;

import java.util.*;

import fatih.baycu.hrms.business.abstracts.JobPostingsService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobPostings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/jobpostings")
public class JobPostingsController {

    private JobPostingsService jobPostingsService;

    @Autowired
    public JobPostingsController(JobPostingsService jobPostingsService) {
        this.jobPostingsService = jobPostingsService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobPostings>> getAll(){
        return this.jobPostingsService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPostings jobPostings){
        return this.jobPostingsService.add(jobPostings);
    }

}
