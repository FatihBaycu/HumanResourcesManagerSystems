package fatih.baycu.hrms.restApi.controllers.JobSeekers;

import fatih.baycu.hrms.business.abstracts.JobSeeker.TechnologyService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-seekers/technologies")
public class TechnologyController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Technology technology){
        return this.technologyService.add(technology);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Technology technology){
        return this.technologyService.update(technology);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Technology technology){
        return this.technologyService.delete(technology);
    }
}
