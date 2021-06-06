package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.concretes.JobPost;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

@Component
public class JobPostValidator implements JobPostValidatorService {
    @Override
    public Result isNullCheck(JobPost jobPost) {
        String description = jobPost.getDescription();
        if (Strings.isNullOrEmpty(description)) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
