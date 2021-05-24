package fatih.baycu.hrms.business.abstracts;

import fatih.baycu.hrms.entities.concretes.JobSeeker;

public interface CheckService{
    boolean CheckIfRealPerson(JobSeeker jobSeeker);
}
