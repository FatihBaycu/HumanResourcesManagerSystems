package fatih.baycu.hrms.entities.concretes.job_seeker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cvs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private JobSeeker jobSeeker;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "cover_letter")
    private String coverLetter;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cv_technologies",
            joinColumns = {@JoinColumn(name = "cv_id")},
            inverseJoinColumns = {@JoinColumn(name = "technology_id")})
    private Set<Technology> technologies = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cv_programming_languages",
            joinColumns = {@JoinColumn(name = "cv_id")},
            inverseJoinColumns = {@JoinColumn(name = "programming_language_id")})
    private Set<ProgrammingLanguage> programmingLanguages = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cv_foreign_languages",
            joinColumns = {@JoinColumn(name = "cv_id")},
            inverseJoinColumns = {@JoinColumn(name = "foreign_language_id")})
    private Set<ForeignLanguage> foreignLanguages = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cv_job_experiences",
            joinColumns = {@JoinColumn(name = "cv_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_experience_id")})
    private Set<JobExperience> jobExperiences = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cv_educations",
            joinColumns = {@JoinColumn(name = "cv_id")},
            inverseJoinColumns = {@JoinColumn(name = "educations_id")})
    private Set<Education> educations = new HashSet<>();





}
