package fatih.baycu.hrms.entities.concretes.job_seeker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_seeker_foreign_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private int languageLevel;

    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();

}
