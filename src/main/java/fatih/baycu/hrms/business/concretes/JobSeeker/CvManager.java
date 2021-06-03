package fatih.baycu.hrms.business.concretes.JobSeeker;

import fatih.baycu.hrms.business.abstracts.JobSeeker.CvService;
import fatih.baycu.hrms.business.abstracts.JobSeeker.TechnologyService;
import fatih.baycu.hrms.business.abstracts.JobSeekerService;
import fatih.baycu.hrms.business.constant.ResultMessages;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.JobSeeker.CvDao;
import fatih.baycu.hrms.entities.concretes.job_seeker.Cv;
import fatih.baycu.hrms.entities.concretes.job_seeker.Technology;
import fatih.baycu.hrms.entities.dtos.CvAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvManager implements CvService {

    private final CvDao cvDao;
    private final JobSeekerService jobSeekerService;
    private final TechnologyService technologyService;

    @Autowired
    public CvManager(CvDao cvDao, JobSeekerService jobSeekerService, TechnologyService technologyService) {
        this.cvDao = cvDao;
        this.jobSeekerService = jobSeekerService;
        this.technologyService = technologyService;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<>(this.cvDao.findAll(), ResultMessages.listed);
    }

    @Override
    public Result add(CvAddDto cvAddDto) {
        var jobSeeker = this.jobSeekerService.getById(cvAddDto.getJobSeekerId());
        if (!jobSeeker.isSuccess()) return jobSeeker;

        var technologies = new ArrayList<Technology>();

        var cv = new Cv(
                jobSeeker.getData(),
                cvAddDto.getGithub(),
                cvAddDto.getLinkedin(),
                cvAddDto.getCoverLetter()
        );

        for (Integer tecnologyId : cvAddDto.getTechnologyIds()) {
            var tecnology = this.technologyService.getById(tecnologyId).getData();
            technologies.add(tecnology);
        }

        cv.getTechnologies().addAll(technologies);

        this.cvDao.save(cv);
        return new SuccessResult(ResultMessages.added);
    }

    @Override
    public Result update(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult(ResultMessages.updated);
    }

    @Override
    public Result delete(Cv cv) {
        this.cvDao.delete(cv);
        return new SuccessResult(ResultMessages.deleted);
    }
}
