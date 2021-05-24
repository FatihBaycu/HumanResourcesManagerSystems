package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
