package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.User;

public interface ActivationCodeService {

    Result sendVerifedCode(ActivationCode activationCode, User user);

}
