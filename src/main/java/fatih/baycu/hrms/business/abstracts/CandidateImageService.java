package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.core.utilities.results.DataResult;
import fatih.baycu.hrms.core.utilities.results.Result;
import fatih.baycu.hrms.entities.concretes.CandidateImage;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface CandidateImageService {
    Result add(CandidateImage candidateImage);
    Result addAll(List<CandidateImage> candidateImage);
    Result add(CandidateImage candidateImage, MultipartFile file);
    DataResult<List<CandidateImage>> getAll();
    DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId);
}
