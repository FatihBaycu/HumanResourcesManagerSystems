package fatih.baycu.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobs")
public @Data
class Job {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="job_id")
     private int jobId;

    @Column(name="job_name")
    private String jobName;

    @Column(name="created_at")
    private LocalDate createdAt=LocalDate.now();

    @Column(name="active")
    private boolean active=true;


}
