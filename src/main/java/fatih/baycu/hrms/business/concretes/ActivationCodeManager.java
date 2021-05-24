package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.ActivationCodeDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class ActivationCodeManager implements ActivationCodeService {

    private ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public Result sendVerifedCode(ActivationCode activationCode, User user) {

        activationCode.setCode("123");
        activationCode.setUserId(user.getId());
        activationCode.setCreatedAt(LocalDate.now());
        this.activationCodeDao.save(activationCode);
        return new SuccessResult("added");
    }
}
