package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService {
    DataResult<List<SchoolDepartment>> getAll();

    Result add(SchoolDepartment schoolDepartment);
    Result update(SchoolDepartment schoolDepartment);
    Result delete(SchoolDepartment schoolDepartment);
}
