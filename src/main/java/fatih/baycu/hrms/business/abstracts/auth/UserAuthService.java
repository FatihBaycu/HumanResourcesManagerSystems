package fatih.baycu.hrms.business.abstracts.auth;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.abstracts.DtoForAuth;
import fatih.baycu.hrms.entities.abstracts.User;

public interface UserAuthService<TDto extends DtoForAuth, TUser extends User> {
    Result register(TDto tDto);

    Result reSendMail(String uid);
}
