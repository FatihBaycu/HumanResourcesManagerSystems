package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobSeeker;

import java.util.*;

public interface JobSeekerService{

    DataResult<List<JobSeeker>> getAll();

    Boolean checkExistByEmail(String email);
    Boolean checkExistByNatiolanityId(String natiolanityId);

    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);


    Result add(JobSeeker jobSeeker);
    Result update(JobSeeker jobSeeker);
}
