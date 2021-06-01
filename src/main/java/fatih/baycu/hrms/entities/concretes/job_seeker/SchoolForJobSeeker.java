package fatih.baycu.hrms.entities.concretes.job_seeker;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="schools_for_job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolForJobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "depertmen_id")
    private int depertmenId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();


}
