package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.EmployerService;
import fatih.baycu.hrms.business.validationRules.EmployerValidatorService;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {
    private final EmployerValidatorService employerValidatorService;

    @Autowired
    public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) {
        super(userDao);
        this.employerValidatorService = employerValidatorService;
    }

    @Override
    public Result add(Employer employer) {
        Result result = BusinessEngine.run(employerValidatorService.employerNullCheck(employer),
                employerValidatorService.isEmailDomainCheck(employer));
        if (result.isSuccess()) {
            return super.add(employer);
        }
        return result;
    }
}
