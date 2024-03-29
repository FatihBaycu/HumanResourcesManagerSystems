package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.*;
import fatih.baycu.hrms.business.constant.Messages;
import fatih.baycu.hrms.business.validationRules.CandidateValidatorService;
import fatih.baycu.hrms.core.adapters.UserRealCheckService;
import fatih.baycu.hrms.core.adapters.models.MernisPerson;
import fatih.baycu.hrms.core.utilities.business.BusinessEngine;
import fatih.baycu.hrms.core.utilities.results.*;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateDao;
import fatih.baycu.hrms.dataAccess.abstracts.UserDao;
import fatih.baycu.hrms.entities.concretes.Candidate;
import fatih.baycu.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

    private final CandidateDao candidateDao;
    private final UserRealCheckService userRealCheckService;
    private final CandidateValidatorService candidateValidatorService;
    private final CandidateEducationService candidateEducationService;
    private final CandidateExperienceService candidateExperienceService;
    private final CandidateImageService candidateImageService;
    private final CandidateLanguageService candidateLanguageService;
    private final CandidateLinkService candidateLinkService;
    private final CandidateSkillService candidateSkillService;


    @Autowired
    public CandidateManager(UserDao<Candidate> userDao, UserRealCheckService userRealCheckService,
                            CandidateValidatorService candidateValidatorService, CandidateEducationService candidateEducationService,
                            CandidateExperienceService candidateExperienceService, CandidateImageService candidateImageService, CandidateLanguageService candidateLanguageService, CandidateLinkService candidateLinkService, CandidateSkillService candidateSkillService) {
        super(userDao);
        this.candidateDao = (CandidateDao) userDao;
        this.userRealCheckService = userRealCheckService;
        this.candidateValidatorService = candidateValidatorService;
        this.candidateEducationService = candidateEducationService;
        this.candidateExperienceService = candidateExperienceService;
        this.candidateImageService = candidateImageService;
        this.candidateLanguageService = candidateLanguageService;
        this.candidateLinkService = candidateLinkService;
        this.candidateSkillService = candidateSkillService;
    }

    @Override
    public Result add(Candidate candidate) {
        Result result = BusinessEngine.run(isIdentityNumberExist(candidate.getNationalIdentity()),
                isMernisVerified(candidate), candidateValidatorService.candidateNullCheck(candidate),
                candidateValidatorService.nationalIdValid(candidate.getNationalIdentity()));
        if (!result.isSuccess()) {
            return result;
        }
        return super.add(candidate);
    }

    @Override
    public DataResult<CvDto> getResumeByCandidateId(int candidateId) {
        CvDto CvDto = new CvDto();
        CvDto.setCandidate(this.getById(candidateId).getData());
        CvDto.setCandidateEducations(this.candidateEducationService.getAllByCandidateIdOrderByGraduationYear(candidateId).getData());
        CvDto.setCandidateExperiences(this.candidateExperienceService.getAllByCandidateIdOrderByLeaveDate(candidateId).getData());
        CvDto.setCandidateImages(this.candidateImageService.getAllByCandidateId(candidateId).getData());
        CvDto.setCandidateLanguages(this.candidateLanguageService.getAllByCandidateId(candidateId).getData());
        CvDto.setCandidateLinks(this.candidateLinkService.getAllByCandidateId(candidateId).getData());
        CvDto.setCandidateSkills(this.candidateSkillService.getAllByCandidateId(candidateId).getData());
        return new SuccessDataResult<>(CvDto);
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<>(this.candidateDao.findById(id).get());
    }

    private Result isIdentityNumberExist(String identityNumber) {
        if (candidateDao.findByNationalIdentity(identityNumber).isPresent()) {
            return new ErrorResult(Messages.nationalityIdentityExist);
        }
        return new SuccessResult();
    }

    private Result isMernisVerified(Candidate candidate) {
        MernisPerson mernisPerson = new MernisPerson(candidate.getFirstName(), candidate.getLastName(),
                candidate.getNationalIdentity(), candidate.getDateOfBirth());
        boolean result = userRealCheckService.validate(mernisPerson);
        if (result) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.personInValid);
    }
}
