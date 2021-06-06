package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService<T extends User> {
    DataResult<List<T>> getAll();

    Result add(T t);

}
