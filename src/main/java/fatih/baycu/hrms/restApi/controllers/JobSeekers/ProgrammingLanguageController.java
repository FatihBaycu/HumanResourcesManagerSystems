package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.ProgrammingLanguageService;
import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.ProgrammingLanguage;
import fatih.baycu.hrms.entities.concretes.job_seeker.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("api/job-seekers/programming-languages")
public class ProgrammingLanguageController {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public DataResult<List<ProgrammingLanguage>> getAll(){
        return this.programmingLanguageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProgrammingLanguage programmingLanguage){
        return this.programmingLanguageService.add(programmingLanguage);
    }

    @PostMapping("/update")
    public Result update(@RequestBody  ProgrammingLanguage programmingLanguage){
        return this.programmingLanguageService.update(programmingLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody  ProgrammingLanguage programmingLanguage){
        return this.programmingLanguageService.delete(programmingLanguage);
    }
}
