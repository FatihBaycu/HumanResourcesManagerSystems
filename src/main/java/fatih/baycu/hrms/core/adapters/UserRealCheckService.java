package fatih.baycu.hrms.core.adapters;

import fatih.baycu.hrms.core.adapters.models.MernisPerson;

public interface UserRealCheckService {
    boolean validate(MernisPerson person);
}
