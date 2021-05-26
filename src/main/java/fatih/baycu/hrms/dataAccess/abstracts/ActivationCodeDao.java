package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer> {

    ActivationCode findActivationCodeByUserId(int id);
    ActivationCode findByCode(String code);


}
