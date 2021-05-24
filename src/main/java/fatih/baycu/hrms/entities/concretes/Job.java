package fatih.baycu.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name="jobs")
public @Data
class Job {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
     private int id;

    @Column(name="job_name")
    private String jobName;

    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="active")
    private boolean active;


}
