package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.JobPostings;
import fatih.baycu.hrms.entities.concretes.dtos.JobPostingsDetail;

import javax.xml.crypto.Data;
import java.util.*;

public interface JobPostingsService {

    DataResult<List<JobPostings>> getAll();

    Result add(JobPostings jobPostings);

    DataResult<List<JobPostingsDetail>>findAllByActiveTrue();

    DataResult<List<JobPostingsDetail>>findAllByActiveTrueOrderByDate();

    DataResult<List<JobPostingsDetail>>findAllByActiveTrueAndEmployerId(int employerId);


}
