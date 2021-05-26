package fatih.baycu.hrms.entities.auth;

import fatih.baycu.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRegister {
    private Employer employer;
    private String passwordConfirm;
}
