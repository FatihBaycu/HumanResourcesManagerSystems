package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.EmployerService;
import fatih.baycu.hrms.business.abstracts.SystemUserService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/personnels")
public class SystemUserController {
    private final EmployerService employerService;
    private final SystemUserService systemUserService;

    @Autowired
    public SystemUserController(EmployerService employerService, SystemUserService systemUserService) {
        this.employerService = employerService;
        this.systemUserService = systemUserService;
    }

    @GetMapping("api/listOfActiveIsFalse")
    public DataResult<List<Employer>> listOfActiveIsFalse() {
        return this.employerService.getByPersonnelActivateFalse();
    }

    @PutMapping("api/activateEmployer")
    @ResponseBody
    public Result activatePersonnel(@RequestParam int userId) {
        return systemUserService.validateEmployer(userId);
    }
}