package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.concretes.LinkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkTypeDao extends JpaRepository<LinkType,Integer> {
}
