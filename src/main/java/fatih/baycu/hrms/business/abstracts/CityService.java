package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.City;

import java.util.*;

public interface CityService {

    Result add(City city);

    DataResult<List<City>> getAll();

}
