package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.EmployerService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import java.util.*;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/empolyer")
public class EmployerController {


    private EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping()
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }
    @PostMapping("add-employer")
    public Result add(@RequestBody Employer employer){
        return employerService.add(employer);

    }

}
