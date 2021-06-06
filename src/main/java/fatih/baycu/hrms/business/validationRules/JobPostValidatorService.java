package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobPost;

public interface JobPostValidatorService {
    public Result isNullCheck(JobPost jobPost);
}
