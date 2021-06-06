package fatih.baycu.hrms.business.validationRules;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.dtos.CvDto;
import org.springframework.stereotype.Component;

@Component
public class CvValidator implements CvValidatorService{
    @Override
    public Result isCvPropNullCheck(CvDto cvDto) {
        return null;
    }
}
