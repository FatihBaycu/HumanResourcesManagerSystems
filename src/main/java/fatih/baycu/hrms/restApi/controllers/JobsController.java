package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.JobService;
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
    public List<Job> getAll(){
        return this.jobService.getAll();
    }

}
