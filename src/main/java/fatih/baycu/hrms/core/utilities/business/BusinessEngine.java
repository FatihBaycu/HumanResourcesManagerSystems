package fatih.baycu.hrms.core.utilities.business;

import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;

public class BusinessEngine {
    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess()) {
                return logic;
            }
        }
        return new SuccessResult();
    }
}
