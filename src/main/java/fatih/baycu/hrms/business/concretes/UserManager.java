package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.UserService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Service
public class UserManager implements UserService {

    private UserDao _userDao;

    @Autowired
    public UserManager(UserDao _userDao) {
        this._userDao = _userDao;
    }

    @Override
    public Result add(User user) {
        user.setActive(true);
        user.setCreatedAt(LocalDate.now());
        this._userDao.save(user);
        return new SuccessResult("User Added");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult(this._userDao.findAll(),"Listed");
    }
}
