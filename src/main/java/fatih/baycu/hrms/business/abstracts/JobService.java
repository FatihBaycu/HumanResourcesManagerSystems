package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {

    List<Job> getAll();
}
