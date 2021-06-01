package fatih.baycu.hrms.business.abstracts.JobSeeker;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.job_seeker.JobExperience;
import fatih.baycu.hrms.entities.concretes.job_seeker.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    DataResult<List<ProgrammingLanguage>> getAll();

    Result add(ProgrammingLanguage programmingLanguage);
    Result update(ProgrammingLanguage programmingLanguage);
    Result delete(ProgrammingLanguage programmingLanguage);


}
