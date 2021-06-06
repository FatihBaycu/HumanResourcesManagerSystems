package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.EmployeeService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.business.validationRules.EmployeeValidatorService;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.core.utilities.verificationtool.CodeGenerator;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {
    private final EmployeeValidatorService employeeValidatorService;

    @Autowired
    public EmployeeManager(UserDao<Employee> userDao, EmployeeValidatorService employeeValidatorService) {
        super(userDao);
        this.employeeValidatorService = employeeValidatorService;
    }

    @Override
    public Result add(Employee employee) {
        Result result = BusinessEngine.run(employeeValidatorService.isEmployeeNullCheck(employee));
        if (!result.isSuccess()) {
            return result;
        }
        employee.setUid(CodeGenerator.generateUuidCode());
        super.add(employee);
        return new SuccessResult(Messages.EmployeeAdded);
    }

}
