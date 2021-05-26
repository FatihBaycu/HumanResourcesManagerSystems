package fatih.baycu.hrms.business.concretes;

import fatih.baycu.hrms.business.abstracts.CheckService;
import fatih.baycu.hrms.entities.concretes.JobSeeker;
import fatih.baycu.hrms.webServices.mernisService.TOKKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CheckService {
    @Override
    public boolean CheckIfRealPerson(JobSeeker jobSeeker) {

        TOKKPSPublicSoap client=new TOKKPSPublicSoap();

        try{
            return client.TCKimlikNoDogrula(
                    Long.parseLong(jobSeeker.getNatiolanityId()),
                    jobSeeker.getFirstName().toUpperCase(),
                    jobSeeker.getLastName().toUpperCase(),
                    jobSeeker.getBirthDate().getYear()

            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


}
