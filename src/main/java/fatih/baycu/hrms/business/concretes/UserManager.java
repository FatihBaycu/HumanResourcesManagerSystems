package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.core.utilities.verificationtool.CodeGenerator;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager<T extends User> implements UserService<T> {
    private final UserDao<T> userDao;

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(this.userDao.findAll(), Messages.USER_LISTED);
    }

    @Override
    public Result add(T t) {
        Result result = BusinessEngine.run(isEmailExist(t.getEmail()));
        if (!result.isSuccess()) {
            return result;
        }
        t.setUid(CodeGenerator.generateUuidCode());
        this.userDao.save(t);
        return new SuccessResult(Messages.userAdded);

    }

    private Result isEmailExist(String email) {
        if(userDao.countUsersWithEmail(email)>0){
            return new ErrorResult(Messages.emailExist);
        }
        return new SuccessResult();
    }
}
