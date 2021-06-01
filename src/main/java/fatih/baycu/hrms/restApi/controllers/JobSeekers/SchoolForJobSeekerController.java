package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolForJobSeekerService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolForJobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/schools-for-job-seejers")
public class SchoolForJobSeekerController {


    private SchoolForJobSeekerService schoolForJobSeekerService;

    @Autowired
    public SchoolForJobSeekerController(SchoolForJobSeekerService schoolForJobSeekerService) {
        this.schoolForJobSeekerService = schoolForJobSeekerService;
    }


    @GetMapping("/getall")
    public DataResult<List<SchoolForJobSeeker>> getAll(){

        return this.schoolForJobSeekerService.getAll();
    }



    @PostMapping("/add")
    public Result add(@RequestBody SchoolForJobSeeker schoolForJobSeeker){
        return this.schoolForJobSeekerService.add(schoolForJobSeeker);
    }

    @PostMapping("/update")
    public Result update(@RequestBody  SchoolForJobSeeker schoolForJobSeeker){
        return this.schoolForJobSeekerService.update(schoolForJobSeeker);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody  SchoolForJobSeeker schoolForJobSeeker){
        return this.schoolForJobSeekerService.delete(schoolForJobSeeker);
    }

}
