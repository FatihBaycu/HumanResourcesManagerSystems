package fatih.baycu.hrms.entities.concretes;

import fatih.baycu.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employers")
public class Employer extends User {

    public Employer(String companyName, String webAddress, String phoneNumber, String email, String password) {
        super(email, password);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "company_name")
    @NotBlank
    private String companyName;

    @Column(name = "web_address")
    @NotBlank
    private String webAddress;

    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobPost> jobPosts;
}
