package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.JobExperienceService;
import fatih.baycu.hrms.business.abstracts.JobSeeker.JobSeekerForeignLanguageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobExperience;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeekerForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/job-experiences")
public class JobExperienceController {

private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }



    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.update(jobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.delete(jobExperience);
    }
}