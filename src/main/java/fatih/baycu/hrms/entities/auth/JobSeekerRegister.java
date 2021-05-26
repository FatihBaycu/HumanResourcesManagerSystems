package fatih.baycu.hrms.entities.auth;

import fatih.baycu.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerRegister {
    private JobSeeker jobSeeker;
    private String passwordConfirm;
}
