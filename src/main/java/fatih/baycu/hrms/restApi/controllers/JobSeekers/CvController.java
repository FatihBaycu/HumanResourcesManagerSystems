package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.CvService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/job-seekers/cv")
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {this.cvService = cvService;}

    @GetMapping("/getall")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {return this.cvService.add(cv);}

    @PostMapping("/update")
    public Result update(@RequestBody Cv cv) {return this.cvService.update(cv);}

    @PostMapping("/delete")
    public Result delete(@RequestBody Cv cv) {return this.cvService.delete(cv);}
}