package fatih.baycu.hrms.business.concretes.auth;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.business.abstracts.auth.EmployerAuthService;
import fatih.baycu.hrms.business.validationRules.AuthValidatorService;
import fatih.baycu.hrms.core.utilities.email.EmailSenderService;
import fatih.baycu.hrms.entities.concretes.Employer;
import fatih.baycu.hrms.entities.dtos.RegisterForEmployerDtoForAuth;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager extends UserAuthManager<RegisterForEmployerDtoForAuth, Employer> implements EmployerAuthService {

    public EmployerAuthManager(AuthValidatorService authValidatorService, UserService<Employer> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Employer newUserInstance(RegisterForEmployerDtoForAuth registerForEmployerDto) {
        return new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAddress(), registerForEmployerDto.getPhoneNumber(), registerForEmployerDto.getEmail(), registerForEmployerDto.getPassword());
    }
}
