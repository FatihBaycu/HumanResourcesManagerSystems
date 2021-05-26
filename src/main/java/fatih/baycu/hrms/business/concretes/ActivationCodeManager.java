package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.ActivationCodeService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.ActivationCodeDao;
import fatih.baycu.hrms.entities.concretes.ActivationCode;
import fatih.baycu.hrms.entities.concretes.Employer;
import fatih.baycu.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    private ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),"Listed");
    }

    @Override
    public Result sendVerifedCode(ActivationCode activationCode, User user) {

        activationCode.setCode("123");
        activationCode.setUserId(user.getId());
        activationCode.setCreatedAt(LocalDate.now());
        this.activationCodeDao.save(activationCode);
        return new SuccessResult("added");
    }

    @Override
    public Boolean checkVerifedCode(ActivationCode activationCode, User user, String code) {

     activationCodeDao.findActivationCodeByUserId(user.getId());

        return null;
    }

    @Override
    public DataResult<ActivationCode> findActivationCodeByUserId(int id) {

        return new  SuccessDataResult<ActivationCode>(activationCodeDao.findActivationCodeByUserId(id),"Listed");

    }



//    @Override
//    public Boolean checkVerifedCode(ActivationCode activationCode, User user,String code) {
//                activationCode.setUserId(user.getId());
//                activationCodeDao.findOne()
//                if(activationCode.getCode()==code){
//                    return true;
//                }
//                return  false;
//    }
}
