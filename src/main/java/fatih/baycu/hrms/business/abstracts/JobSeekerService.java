package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobSeeker;

import java.util.*;

public interface JobSeekerService{

    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    Boolean checkExistByEmail(String email);
    Boolean checkExistByNatiolanityId(String natiolanityId);
    Boolean checkEmailVerifedCode(JobSeeker jobSeeker);
}
