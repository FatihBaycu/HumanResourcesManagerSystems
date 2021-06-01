package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Technology;

import java.util.List;

public interface TechnologyService {

    DataResult<List<Technology>> getAll();

    Result add(Technology technology);
    Result update(Technology technology);
    Result delete(Technology technology);


}
