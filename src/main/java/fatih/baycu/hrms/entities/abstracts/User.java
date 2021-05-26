package fatih.baycu.hrms.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public @Data
class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name="created_at")
    private LocalDate createdAt=LocalDate.now();
    @Column(name="active")
    private boolean active=true;


    private String email;

    @Column(name="email_verified")
    private boolean emailVerified=false;


    private String password;
}
