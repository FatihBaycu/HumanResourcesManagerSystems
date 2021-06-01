package fatih.baycu.hrms.restApi.controllers;

import fatih.baycu.hrms.business.abstracts.AuthService;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.auth.EmployerRegister;
import fatih.baycu.hrms.entities.auth.JobSeekerRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("registerForJobSeeker")
    public Result registerForJobSeeker(@RequestBody JobSeekerRegister jobSeekerRegister) {
        return this.authService.registerForJobSeeker(jobSeekerRegister);
    }

    @PostMapping("registerForEmployer")
    public Result registerForEmployer(@RequestBody EmployerRegister employerRegister) {
        return this.authService.registerForEmployer(employerRegister);
    }


    @GetMapping("activateEmail")
    @ResponseBody
    public Result activateEmail(@RequestParam String activationCode) {
        return this.authService.activateEmail(activationCode);
    }
}