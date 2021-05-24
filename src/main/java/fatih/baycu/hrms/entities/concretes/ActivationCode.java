package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mail_activation_codes")
public @Data
class ActivationCode {
     @Id
     @GeneratedValue(strategy =GenerationType.IDENTITY)
     @Column(name = "id")
    private int id;
     
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "code")
    private String code;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "activate")
    private  boolean activate;
}
