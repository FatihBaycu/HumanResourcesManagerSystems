package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.ActivationCode;

import java.util.List;
import java.util.Optional;

public interface ActivationCodeService {
    DataResult<List<ActivationCode>> getAll();

    Result add(ActivationCode activationCode);

    Result update(ActivationCode activationCode);

    DataResult<Optional<ActivationCode>> getByUserUid(String uid);
}
