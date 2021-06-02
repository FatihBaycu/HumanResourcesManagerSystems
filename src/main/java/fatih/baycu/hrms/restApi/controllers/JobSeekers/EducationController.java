package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.EducationService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/educations")
public class EducationController {


    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){return this.educationService.getAll();}

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @PostMapping("/update")
    public Result update(@RequestBody  Education education){
        return this.educationService.update(education);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody  Education education){
        return this.educationService.delete(education);
    }

}
