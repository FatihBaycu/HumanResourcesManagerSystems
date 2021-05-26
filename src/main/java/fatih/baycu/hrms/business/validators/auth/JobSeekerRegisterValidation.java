package fatih.baycu.hrms.business.validators.auth;

import fatih.baycu.hrms.business.validators.ValidationBase;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.entities.auth.JobSeekerRegister;

public class JobSeekerRegisterValidation extends ValidationBase {

    public static ErrorResult checkValidate(JobSeekerRegister jobSeekerRegister) {
        boolean result = true;

        var jobSeeker = jobSeekerRegister.getJobSeeker();

        if (!ValidationBase.requiredString(jobSeeker.getFirstName()))
            result = false;

        if (!ValidationBase.requiredString(jobSeeker.getLastName()))
            result = false;

        if (!ValidationBase.requiredString(jobSeeker.getNatiolanityId()))
            result = false;

        if (!ValidationBase.requiredInteger(jobSeeker.getBirthDate().getYear()))
            result = false;

        if (!UserRegisterValidation.checkValidate(jobSeeker))
            result = false;

        boolean passwordResult = ValidationBase.confirmPassword(jobSeeker.getPassword(), jobSeekerRegister.getPasswordConfirm());

        if (!passwordResult)
            return new ErrorResult("Şifreler uyuşmuyor");

        if (!result)
            return new ErrorResult("Boş alan bırakmayın");

        return null;
    }
}