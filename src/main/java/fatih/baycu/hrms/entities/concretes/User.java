package fatih.baycu.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public @Data
class User {

    @GeneratedValue
    @Id
    @Column(name="id")
    private int id;
    @Column(name="created_at")
    private LocalDate createdAt;
    @Column(name="active")
    private boolean active;
}
