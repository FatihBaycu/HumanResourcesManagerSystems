package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.abstracts.User;
import com.google.common.base.Strings;

public class UserValidator implements UserValidatorService {

    public Result userNullCheck(User user) {

        if (Strings.isNullOrEmpty(user.getEmail()) || Strings.isNullOrEmpty(user.getPassword())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
