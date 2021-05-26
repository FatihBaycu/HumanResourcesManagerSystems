package fatih.baycu.hrms.business.validators.auth;

import fatih.baycu.hrms.business.validators.ValidationBase;
import fatih.baycu.hrms.entities.abstracts.User;

public class UserRegisterValidation {
    public static boolean checkValidate(User user) {
        if(!ValidationBase.requiredString(user.getEmail())) return false;
        return ValidationBase.requiredString(user.getPassword());
    }
}