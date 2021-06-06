package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.concretes.Candidate;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService {
    public Result candidateNullCheck(Candidate candidate) {
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        String tc = candidate.getNationalIdentity();
        Date birth = candidate.getDateOfBirth();


        if (!super.userNullCheck(candidate).isSuccess() || (Strings.isNullOrEmpty(firstName)) ||
                (Strings.isNullOrEmpty(lastName)) || (Strings.isNullOrEmpty(tc)) || birth == null) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

    @Override
    public Result nationalIdValid(String nationalIdentity) {
        if (nationalIdentity.length() == 11) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.nationalIdentityInvalid);
    }
}
