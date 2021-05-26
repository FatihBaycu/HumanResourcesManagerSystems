package fatih.baycu.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public @Data
class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="created_at")
    private LocalDate createdAt;
    @Column(name="active")
    private boolean active;
}
