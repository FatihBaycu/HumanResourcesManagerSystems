package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.dtos.CvDto;

public interface CvValidatorService {
    Result isCvPropNullCheck(CvDto cvDto);
}
