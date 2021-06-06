package fatih.baycu.hrms.business.concretes.auth;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.business.abstracts.auth.CandidateAuthService;
import fatih.baycu.hrms.business.validationRules.AuthValidatorService;
import fatih.baycu.hrms.core.utilities.email.EmailSenderService;
import fatih.baycu.hrms.entities.concretes.Candidate;
import fatih.baycu.hrms.entities.dtos.RegisterForCandidateDtoForAuth;
import org.springframework.stereotype.Service;


@Service
public class CandidateAuthManager extends UserAuthManager<RegisterForCandidateDtoForAuth, Candidate> implements CandidateAuthService {


    public CandidateAuthManager(AuthValidatorService authValidatorService, UserService<Candidate> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Candidate newUserInstance(RegisterForCandidateDtoForAuth registerForCandidateDto) {
        return new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword(),registerForCandidateDto.getDescription());
    }
}
