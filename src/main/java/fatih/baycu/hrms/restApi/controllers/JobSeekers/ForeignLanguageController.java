package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.ForeignLanguageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/job-seekers/languages")
public class ForeignLanguageController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }


    @GetMapping("/getall")
    public DataResult<List<ForeignLanguage>> getAll() {
        return this.foreignLanguageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody ForeignLanguage foreignLanguage) {
        return this.foreignLanguageService.add(foreignLanguage);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ForeignLanguage foreignLanguage) {
        return this.foreignLanguageService.update(foreignLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody ForeignLanguage foreignLanguage) {
        return this.foreignLanguageService.delete(foreignLanguage);
    }
}