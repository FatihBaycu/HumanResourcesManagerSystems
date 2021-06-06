package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CandidateImageService;
import fatih.baycu.hrms.core.utilities.imageService.ImageService;
import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.core.utilities.results.SuccessDataResult;
import fatih.baycu.hrms.core.utilities.results.SuccessResult;
import fatih.baycu.hrms.dataAccess.abstracts.CandidateImageDao;
import fatih.baycu.hrms.entities.concretes.CandidateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CandidateImageManager implements CandidateImageService {
    private final CandidateImageDao candidateImageDao;
    private final ImageService imageService;

    @Autowired
    public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService) {
        this.candidateImageDao = candidateImageDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(CandidateImage candidateImage) {
        this.candidateImageDao.save(candidateImage);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateImage> candidateImage) {
        candidateImageDao.saveAll(candidateImage);
        return new SuccessResult();
    }

    @Override
    public Result add(CandidateImage candidateImage, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        candidateImage.setUrl(url);
        candidateImage.setUploadedDate(LocalDateTime.now());
        return add(candidateImage);
    }

    @Override
    public DataResult<List<CandidateImage>> getAll() {
        return new SuccessDataResult<>(this.candidateImageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateImageDao.getAllByCandidateId(candidateId));
    }
}
