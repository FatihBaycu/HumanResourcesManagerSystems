package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
    Result employerNullCheck(Employer employer);
    Result isEmailDomainCheck(Employer employer);
}
