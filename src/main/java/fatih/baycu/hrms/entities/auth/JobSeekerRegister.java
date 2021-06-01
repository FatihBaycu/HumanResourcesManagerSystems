package fatih.baycu.hrms.entities.auth;

import fatih.baycu.hrms.entities.concretes.job_seeker.JobSeeker;
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
