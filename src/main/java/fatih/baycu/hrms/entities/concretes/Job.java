package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="jobs")
public @Data
class Job {

    @Id
    @GeneratedValue
    @Column(name="id")
     private int id;

    @Column(name="job_name")
    private String jobName;

    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="active")
    private boolean active;


}
