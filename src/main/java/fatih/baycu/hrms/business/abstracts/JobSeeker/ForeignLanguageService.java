package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import fatih.baycu.hrms.entities.concretes.job_seeker.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignLanguageService{

    DataResult<List<ForeignLanguage>> getAll();

    Result add(ForeignLanguage foreignLanguage);
    Result update(ForeignLanguage foreignLanguage);
    Result delete(ForeignLanguage foreignLanguage);

}
