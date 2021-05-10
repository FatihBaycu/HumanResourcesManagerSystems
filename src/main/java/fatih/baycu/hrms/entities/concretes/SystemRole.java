package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "system_roles")
public @Data
class SystemRole {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="role_name")
    private String roleName;
}
