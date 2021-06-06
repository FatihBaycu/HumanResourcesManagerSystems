package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.LinkType;

import java.util.List;

public interface LinkTypeService {
    Result add(LinkType linkType);
    DataResult<List<LinkType>> getAll();
}
