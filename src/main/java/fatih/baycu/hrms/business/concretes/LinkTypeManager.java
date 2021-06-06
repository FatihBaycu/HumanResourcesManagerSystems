package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.LinkTypeService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.LinkTypeDao;
import fatih.baycu.hrms.entities.concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkTypeManager implements LinkTypeService {
    private final LinkTypeDao linkTypeDao;

    @Autowired
    public LinkTypeManager(LinkTypeDao linkTypeDao) {
        this.linkTypeDao = linkTypeDao;
    }

    @Override
    public Result add(LinkType linkType) {
        this.linkTypeDao.save(linkType);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<LinkType>> getAll() {
        return new SuccessDataResult<>(this.linkTypeDao.findAll());
    }
}
