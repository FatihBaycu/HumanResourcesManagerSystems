package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.dtos.CvDto;

public interface CvService {
    Result add(CvDto cvDto, int candidateId);
}
