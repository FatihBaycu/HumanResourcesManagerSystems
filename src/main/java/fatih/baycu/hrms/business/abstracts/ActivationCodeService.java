package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.ActivationCode;

import java.util.*;

public interface ActivationCodeService {

    DataResult<List<ActivationCode>> getAll();
    DataResult<ActivationCode> getByCode(String code);
    Result add(ActivationCode activationCode);
    Result update(ActivationCode activationCode);
    Result delete(ActivationCode activationCode);



}
