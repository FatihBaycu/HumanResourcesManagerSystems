package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.Employer;
import fatih.baycu.hrms.entities.concretes.User;

import java.util.*;

public interface ActivationCodeService {

    DataResult<List<ActivationCode>> getAll();
    Result sendVerifedCode(ActivationCode activationCode, User user);
    Boolean checkVerifedCode(ActivationCode activationCode,User user,String code);
    DataResult<ActivationCode> findActivationCodeByUserId(int id);

}
