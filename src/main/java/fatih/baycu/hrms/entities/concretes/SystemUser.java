package fatih.baycu.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "system_users")
@NoArgsConstructor
@AllArgsConstructor
public @Data
class SystemUser {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="system_role")
    private int systemRole;

    @Column(name="email")
    private String email;

    @Column(name="password_hash")
    private int passwordHash;

}
