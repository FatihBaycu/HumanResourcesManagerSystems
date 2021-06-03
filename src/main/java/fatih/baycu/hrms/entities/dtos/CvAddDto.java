package fatih.baycu.hrms.entities.dtos;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvAddDto {

    private int jobSeekerId;
    //private String imageUrl;
    private String github;
    private String linkedin;
    private String coverLetter;
    private List<Integer> educationIds;
    private List<Integer> jobExperienceIds;
    private List<Integer> foreignLanguageIds;
    private List<Integer> programmingLanguageIds;
    private List<Integer> technologyIds;
}
