package fatih.baycu.hrms.dataAccess.abstracts;

import fatih.baycu.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
    @Query("SELECT COUNT(u.id) FROM User u WHERE u.email=:email") int
            countUsersWithEmail(String email);
}
