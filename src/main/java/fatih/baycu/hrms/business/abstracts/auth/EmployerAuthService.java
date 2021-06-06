package fatih.baycu.hrms.business.abstracts.auth;


import fatih.baycu.hrms.entities.concretes.Employer;
import fatih.baycu.hrms.entities.dtos.RegisterForEmployerDtoForAuth;


public interface EmployerAuthService extends UserAuthService<RegisterForEmployerDtoForAuth, Employer> {
}
