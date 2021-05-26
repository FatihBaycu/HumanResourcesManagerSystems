package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.auth.EmployerRegister;
import fatih.baycu.hrms.entities.auth.JobSeekerRegister;
import fatih.baycu.hrms.entities.abstracts.User;

public interface AuthService {
    Result registerForJobSeeker(JobSeekerRegister jobSeekerRegister);
    Result registerForEmployer(EmployerRegister employerRegister);
    //Result login(User user);
    Result activateEmail(String activationCode);
}
