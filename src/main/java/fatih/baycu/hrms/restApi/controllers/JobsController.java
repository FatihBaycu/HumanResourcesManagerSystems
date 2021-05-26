package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.JobService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/jobs")
public class JobsController {

    private final JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("getall")
    public DataResult<List<Job>> getAll(){
        return this.jobService.getAll();
    }

    @GetMapping("get-by-name")
    public DataResult<Job> getByJobName(String jobName){
        return this.jobService.getByJobName(jobName);
    }

    @PostMapping("add-job")
    public Result add(@RequestBody Job job){return this.jobService.add(job);}
}
