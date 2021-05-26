package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.ActivationCodeDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivationCodeManager implements ActivationCodeService {



    private final ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return null;
    }

    public DataResult<ActivationCode> getByCode(String code) {
        var result = activationCodeDao.findByCode(code);

        return result == null
                ? new ErrorDataResult<>("Aktivasyon kodu bulunamadı")
                : new SuccessDataResult<>(result, "Activasyon kodu bulundu");
    }

    public Result add(ActivationCode activationCode) {
        var checkCode = checkExistingCode(activationCode.getCode());

        if (checkCode)
            return new ErrorResult("Bu kod zaten mevcut");

        this.activationCodeDao.save(activationCode);
        return new SuccessDataResult<>(activationCode, "Oluşturuldu");
    }

    public Result update(ActivationCode activationCode) {
        this.activationCodeDao.save(activationCode);
        return new SuccessDataResult<>(activationCode, "Güncellendi");
    }

    public Result delete(ActivationCode activationCode) {
        this.activationCodeDao.save(activationCode);
        return new SuccessResult("Silindi");
    }

    private boolean checkExistingCode(String code) {
        return getByCode(code).isSuccess();
    }
    
}
