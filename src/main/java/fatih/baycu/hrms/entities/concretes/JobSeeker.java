package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="job_seekers")
public @Data
class JobSeeker {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="natiolanity_id")
    private String natiolanityId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="email")
    private String email;

    @Column(name="email_verified")
    private boolean emailVerified;

    @Column(name="password_hash")
    private String passwordHash;


}
