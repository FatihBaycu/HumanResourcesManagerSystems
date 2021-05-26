package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.EmployerService;
import fatih.baycu.hrms.business.abstracts.SystemUserService;
import fatih.baycu.hrms.core.utilities.results.ErrorResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserManager implements SystemUserService {

    private final EmployerService employerService;

    @Autowired
    public SystemUserManager(EmployerService employerService) {
        this.employerService = employerService;
    }

    public Result validateEmployer(int userId) {
        var employer = employerService.getById(userId);
        if (!employer.isSuccess())
            return employer;

        if (employer.getData().isStatus())
            return new ErrorResult("Kullanıcı zaten onaylanmış");

        employer.getData().setStatus(true);

        var result = this.employerService.update(employer.getData());
        if (!result.isSuccess())
            return result;

        return new SuccessResult("İş veren onaylandı");
    }
}
