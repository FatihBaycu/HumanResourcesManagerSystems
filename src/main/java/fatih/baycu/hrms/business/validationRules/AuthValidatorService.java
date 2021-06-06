package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;

public interface AuthValidatorService {
    Result isPasswordConfirmed(String password, String confirmPassword);
}
