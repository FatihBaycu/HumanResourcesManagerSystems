package fatih.baycu.hrms.business.abstracts.auth;

import fatih.baycu.hrms.core.utilities.results.Result;

public interface VerifyService {
    Result verify(String uid, String activationCode);
}
