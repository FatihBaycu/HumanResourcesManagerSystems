package fatih.baycu.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingsDetail {


    private int id;

    private String companyName;

    private String jobName;

    private boolean active;

    private double numberOfEmployee;

    private LocalDate applicationDeadline;

    private LocalDate createdAt;

}
