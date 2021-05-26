package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.Employer;
import java.util.*;
public interface EmployerService {

    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int userId);
    DataResult<List<Employer>> getByPersonnelActivateFalse();

    Result add(Employer employer);
    Result update(Employer employer);

}
