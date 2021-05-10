package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="employers")
public @Data
class Employer {
    @Id
    @GeneratedValue
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
    private String emailVerified;

    @Column(name="password_hash")
    private boolean passwordHash;


}
