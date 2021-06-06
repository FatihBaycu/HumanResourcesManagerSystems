package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.abstracts.User;

public interface UserValidatorService {
    Result userNullCheck(User user);
}
