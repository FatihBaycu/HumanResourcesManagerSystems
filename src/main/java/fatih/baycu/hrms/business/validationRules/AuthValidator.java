package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator implements AuthValidatorService {
    public Result isPasswordConfirmed(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.PasswordNotConfirmed);
    }
}
