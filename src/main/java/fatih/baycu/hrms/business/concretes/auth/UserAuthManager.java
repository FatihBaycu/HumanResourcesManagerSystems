package fatih.baycu.hrms.business.concretes.auth;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.business.abstracts.auth.UserAuthService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.business.validationRules.AuthValidatorService;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.email.EmailSenderService;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.core.utilities.verificationtool.CodeGenerator;
import fatih.baycu.hrms.entities.abstracts.DtoForAuth;
import fatih.baycu.hrms.entities.abstracts.User;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class UserAuthManager<TDto extends DtoForAuth, TUser extends User> implements UserAuthService<TDto, TUser> {


    private final AuthValidatorService authValidatorService;
    private final UserService<TUser> userService;
    private final ActivationCodeService activationCodeService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public UserAuthManager(AuthValidatorService authValidatorService, UserService<TUser> userService,
                           ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(TDto tDto) {
        Result result = BusinessEngine.run(authValidatorService
                .isPasswordConfirmed(tDto.getPassword(),
                        tDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        TUser user = newUserInstance(tDto);
        Result addResult = userService.add(user);
        if (!addResult.isSuccess()) {
            return addResult;
        }
        String code = CodeGenerator.generateUuidCode();
        Result codeAddResult = activationCodeAdd(user, code);
        if (!codeAddResult.isSuccess()) {
            return codeAddResult;
        }
        emailSenderService.send("Doğrulama için linke tıklayınız : http://localhost:8080/api/auth/verify?activationCode=" + code + "&uid=" + user.getUid());
        emailSenderService.send("Tekrar kod üretmek için linke tıklayınız : http://localhost:8080/api/auth/resend?uid=" + user.getUid());
        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public Result reSendMail(String uid) {
        String activationCode = CodeGenerator.generateUuidCode();
        return activationCodeUpdate(uid, activationCode);
    }

    public abstract TUser newUserInstance(TDto tDto);

    private Result activationCodeAdd(User user, String code) {
        ActivationCode activationCode = new ActivationCode();
        activationCode.setActivationCode(code);
        activationCode.setUser(user);
        Result activationResult = activationCodeService.add(activationCode);
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }

    private Result activationCodeUpdate(String uid, String code) {
        Optional<ActivationCode> updateResult = activationCodeService.getByUserUid(uid).getData();
        if (updateResult.get().isConfirmed()) {
            return new ErrorResult("Doğrulanmış bir kullanıcı için kod oluşturulamaz");
        }
        updateResult.get().setExpirationDate(LocalDateTime.now().plusMinutes(5));
        updateResult.get().setActivationCode(code);
        emailSenderService.send("Doğrulama için linke tıklayınız : http://localhost:8080/api/auth/verify?activationCode=" + code + "&uid=" + uid);
        Result activationResult = activationCodeService.update(updateResult.get());
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }
}
