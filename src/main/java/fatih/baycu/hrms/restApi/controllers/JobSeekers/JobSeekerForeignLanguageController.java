package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.JobSeekerForeignLanguageService;
import fatih.baycu.hrms.business.abstracts.JobSeeker.ProgrammingLanguageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeekerForeignLanguage;
import fatih.baycu.hrms.entities.concretes.job_seeker.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/job-seekers/languages")
public class JobSeekerForeignLanguageController {

    private JobSeekerForeignLanguageService jobSeekerForeignLanguageService;


    @Autowired
    public JobSeekerForeignLanguageController(JobSeekerForeignLanguageService jobSeekerForeignLanguageService) {
        this.jobSeekerForeignLanguageService = jobSeekerForeignLanguageService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobSeekerForeignLanguage>> getAll() {
        return this.jobSeekerForeignLanguageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        return this.jobSeekerForeignLanguageService.add(jobSeekerForeignLanguage);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        return this.jobSeekerForeignLanguageService.update(jobSeekerForeignLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        return this.jobSeekerForeignLanguageService.delete(jobSeekerForeignLanguage);
    }
}