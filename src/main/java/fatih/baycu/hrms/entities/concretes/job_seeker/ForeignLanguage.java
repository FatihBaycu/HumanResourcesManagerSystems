package fatih.baycu.hrms.entities.concretes.job_seeker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "foreign_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private int languageLevel;

    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "foreignLanguages")
    private List<Cv> cvs;

}
