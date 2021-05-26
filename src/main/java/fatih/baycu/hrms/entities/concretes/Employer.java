package fatih.baycu.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
public @Data
class Employer {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="web_site")
    private String webSite;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="status")
    private boolean status;

    @Column(name="email")
    private String email;

    @Column(name="email_verified")
    private boolean emailVerified;

    @Column(name="password_hash")
    private String passwordHash;
}
