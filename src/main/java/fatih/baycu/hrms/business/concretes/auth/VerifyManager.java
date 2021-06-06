package fatih.baycu.hrms.business.concretes.auth;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.auth.VerifyService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerifyManager implements VerifyService {

    private final ActivationCodeService activationCodeService;

    @Autowired
    public VerifyManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    public Result verify(String uid, String activationCode) {
        Optional<ActivationCode> activation = activationCodeService.getByUserUid(uid).getData();
        Result result = subVerify(activation, activationCode);
        if (!result.isSuccess()) {
            return result;
        }
        activation.get().setConfirmed(true);
        activation.get().setActivationDate(LocalDateTime.now());
        activationCodeService.update(activation.get());
        return new SuccessResult(Messages.codeVerified);
    }

    private Result subVerify(Optional<ActivationCode> activation, String activationCode) {
        if (activation.isEmpty()) {
            return new ErrorResult(Messages.codeNotFound);
        }
        if (activation.get().isConfirmed()) {
            return new ErrorResult(Messages.activationExist);
        }
        if (activation.get().getExpirationDate().isBefore(LocalDateTime.now())) {
            return new ErrorResult(Messages.codeExpired);
        }
        if (!activation.get().getActivationCode().equals(activationCode)) {
            return new ErrorResult(Messages.codeNotEqual);
        }
        return new SuccessResult();
    }
}
