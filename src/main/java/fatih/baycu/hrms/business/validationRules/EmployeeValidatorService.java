package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Employee;

public interface EmployeeValidatorService {
    public Result isEmployeeNullCheck(Employee employee);
}
