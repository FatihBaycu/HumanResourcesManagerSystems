package fatih.baycu.hrms.entities.concretes.job_seeker;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="school_departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="departmen_name")
    private String departmenName;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt=LocalDate.now();

}
