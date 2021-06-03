package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import fatih.baycu.hrms.entities.dtos.CvAddDto;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();

    Result add(CvAddDto cvAddDto);
    Result update(Cv cv);
    Result delete(Cv cv);
}
