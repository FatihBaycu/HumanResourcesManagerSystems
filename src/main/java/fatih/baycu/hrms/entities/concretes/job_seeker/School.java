package fatih.baycu.hrms.entities.concretes.job_seeker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="schools")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name = "school_name")
        private String schoolName;

        @JsonIgnore
        @Column(name = "created_at")
        private LocalDate createdAt=LocalDate.now();





}
