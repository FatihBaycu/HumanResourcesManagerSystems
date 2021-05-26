package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.ActivationCodeDao;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.abstracts.User;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final ActivationCodeService activationCodeService;

    @Autowired
    public UserManager(UserDao userDao, ActivationCodeService activationCodeService) {
        this.userDao = userDao;
        this.activationCodeService = activationCodeService;
    }

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll());
    }

    public DataResult<User> getById(int id) {
        var result = this.userDao.findById(id);
        return result.isEmpty()
                ? new ErrorDataResult<>(null, "Kullanıcı bulunamadı")
                : new SuccessDataResult<>(result.get(), "Kullanıcı bulundu");
    }

    public DataResult<User> getByEmail(String email) {
        var result = this.userDao.findByEmail(email);
        return result != null ? new SuccessDataResult<>(result, "Kullanıcı mevcut") : new ErrorDataResult<>("Kullanıcı bulunamadı");
    }

    public Result add(User user) {
        this.userDao.save(user);
        return createEmailVerification(user.getEmail());
    }

    private Result createEmailVerification(String email) {
        var user = getByEmail(email);
        if (!user.isSuccess())
            return user;

        var emailVerification = new ActivationCode();
        emailVerification.setUserId(user.getData().getId());
        emailVerification.setCode(createCode());

        return this.activationCodeService.add(emailVerification);
    }

    private String createCode() {
        UUID uuid = UUID.randomUUID();

        var formatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
        var localDateTime = LocalDateTime.now();

        return formatter.format(localDateTime) + uuid;
    }

    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult("Güncellendi");
    }

    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult("Silindi");
    }

    public Result activateUser(int id, String code) {
        var user = this.userDao.findById(id);

        if (user.isEmpty()) return new ErrorResult("Active edilecek Kullanıcı bulunamadı");

        user.get().setEmailVerified(true);
        return new SuccessDataResult<>(user);
    }
}