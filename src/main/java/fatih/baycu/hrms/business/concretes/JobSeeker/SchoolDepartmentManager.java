package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.SchoolDepartmentService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.SchoolDepartmentDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<>(this.schoolDepartmentDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        this.schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(SchoolDepartment schoolDepartment) {
        this.schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult(ResultMessages.updated);    }

    @Override
    public Result delete(SchoolDepartment schoolDepartment) {
        this.schoolDepartmentDao.delete(schoolDepartment);
        return new SuccessResult(ResultMessages.deleted);    }
}
