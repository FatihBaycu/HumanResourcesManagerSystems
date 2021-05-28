package fatih.baycu.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "job_postings")
@NoArgsConstructor
@AllArgsConstructor
public class JobPostings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "job_position_id")
//    private int jobPositionId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

//    @Column(name = "city_id")
//    private int cityId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

//    @Column(name = "employer_id")
//    private int employerId;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "salary_min")
    private int salaryMin;

    @Column(name = "salary_max")
    private int salaryMax;

    @Column(name = "number_of_employee")
    private double numberOfEmployee;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();

}
