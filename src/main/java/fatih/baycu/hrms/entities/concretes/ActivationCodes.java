package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activation_codes")
public @Data
class ActivationCodes {
     @Id
     @GeneratedValue
     @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "code")
    private int code;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "activate")
    private  boolean activate;
}
