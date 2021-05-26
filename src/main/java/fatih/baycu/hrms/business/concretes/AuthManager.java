package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.*;
import fatih.baycu.hrms.business.validators.auth.EmployerRegisterValidation;
import fatih.baycu.hrms.business.validators.auth.JobSeekerRegisterValidation;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.abstracts.User;
import fatih.baycu.hrms.entities.auth.EmployerRegister;
import fatih.baycu.hrms.entities.auth.JobSeekerRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {


    private final UserService userService;
    private final JobSeekerService jobSeekerService;
    private final EmployerService employerService;
    //private final IdentityValidationService identityValidationService;
    private final ActivationCodeService activationCodeService;


    @Autowired
    public AuthManager(UserService userService,
                       JobSeekerService jobSeekerService,
                       EmployerService employerService,
                       //IdentityValidationService identityValidationService,
                       ActivationCodeService activationCodeService) {
        this.userService = userService;
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        //this.identityValidationService = identityValidationService;
        this.activationCodeService = activationCodeService;
    }

    @Override
    public Result registerForJobSeeker(JobSeekerRegister jobSeekerRegister) {
        var validate = JobSeekerRegisterValidation.checkValidate(jobSeekerRegister);
        if (validate != null) return validate;

        var jobSeeker = jobSeekerRegister.getJobSeeker();

        //boolean checkRealUser = this.identityValidationService.validate(jobSeeker);

//        if (!checkRealUser)
//            return new ErrorResult("Girilen bilgiler geçersiz");

        var checkIdentity = checkUserByIdentityNumber(jobSeeker.getNatiolanityId());
        if (checkIdentity != null) return checkIdentity;

        var result = addUser(jobSeeker);
        if (!result.isSuccess()) return result;

        this.jobSeekerService.add(jobSeeker);

        return new SuccessResult("Kayıt olundu");
    }

    @Override
    public Result registerForEmployer(EmployerRegister employerRegister) {
        var validate = EmployerRegisterValidation.checkValidate(employerRegister);
        if (validate != null) return validate;
        var employer = employerRegister.getEmployer();

        var result = addUser(employer);
        if (!result.isSuccess()) return result;

        this.employerService.add(employer);

        return new SuccessResult("Kayıt olundu");    }

    @Override
    public Result activateEmail(String activationCode) {
        var existingEmailCode = this.activationCodeService.getByCode(activationCode);
        if (!existingEmailCode.isSuccess()) return existingEmailCode;

        if (!existingEmailCode.getData().isActivate())
            return new ErrorResult("Bu kod artık geçersiz lütfen yeni bir kod isteyin");

        var user = this.userService.getById(existingEmailCode.getData().getUserId());
        if (!user.isSuccess()) return user;

        user.getData().setEmailVerified(true);
        var result = this.userService.update(user.getData());

        return result.isSuccess()
                ? new SuccessResult("Email aktivasyonu başarılı")
                : new ErrorResult("Email aktivasyonu başarısız");
    }

    private DataResult<User> addUser(User user) {
        var existingEmail = this.userService.getByEmail(user.getEmail());
        if (existingEmail.isSuccess()) return existingEmail;

        this.userService.add(user);
        return this.userService.getByEmail(user.getEmail());
    }

    private Result checkUserByIdentityNumber(String identityNumber) {
        var jobSeeker = this.jobSeekerService.getByIdentityNumber(identityNumber);

        if (jobSeeker.isSuccess())
            return new ErrorResult("Kimlik numarası kullanımda");

        return null;
    }
}
